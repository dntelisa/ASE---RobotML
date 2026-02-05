import * as fs from 'fs';
import * as path from 'path';
import { URI } from 'langium';
import { LangiumCoreServices, LangiumDocument } from 'langium';
import { Diagnostic } from 'vscode-languageserver';

/**
 * Charge un document Langium depuis un fichier et vérifie les erreurs.
 */
export async function extractDocument(fileName: string, services: LangiumCoreServices): Promise<LangiumDocument> {
    const extensions = services.LanguageMetaData.fileExtensions;
    if (!extensions.includes(path.extname(fileName))) {
        console.error(`Please choose a file with one of these extensions: ${extensions}.`);
        process.exit(1);
    }

    if (!fs.existsSync(fileName)) {
        console.error(`File ${fileName} does not exist.`);
        process.exit(1);
    }

    const uri = URI.file(path.resolve(fileName));
    
    const document = await services.shared.workspace.LangiumDocuments.getOrCreateDocument(uri);
    
    // Construction du document (validation, link, etc.)
    await services.shared.workspace.DocumentBuilder.build([document]);

    const validationErrors = (document.diagnostics ?? []).filter((e: Diagnostic) => e.severity === 1);
    
    if (validationErrors.length > 0) {
        console.error('There are validation errors:');
        for (const validationError of validationErrors) {
            console.error(`line ${validationError.range.start.line + 1}: ${validationError.message} [${document.textDocument.getText(validationError.range)}]`);
        }
        process.exit(1);
    }

    return document;
}

/**
 * Extrait directement la racine de l'AST (le Programme) depuis un fichier.
 */
export async function extractAstNode<T>(fileName: string, services: LangiumCoreServices): Promise<T> {
    // extractDocument est async, donc on doit 'await' le résultat
    const document = await extractDocument(fileName, services);
    
    // Acces direct à la racine de l'AST (le Programme) et cast vers le type générique T
    return document.parseResult?.value as T;
}