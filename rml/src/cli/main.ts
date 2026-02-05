import { Command } from 'commander';
import { RobotMlCompiler } from '../semantics/compiler.js';
import { createRobotMlServices } from '../language/robot-ml-module.js';
import { extractAstNode } from './cli-utils.js';
import { Programme } from '../language/generated/ast.js';
import { NodeFileSystem } from 'langium/node';
import * as fs from 'fs';
import * as path from 'path';


export type GenerateOptions = {
    destination?: string;
}

export const generateAction = async (fileName: string, opts: GenerateOptions): Promise<void> => {
    const services = createRobotMlServices(NodeFileSystem).RobotMl;
    const model = await extractAstNode<Programme>(fileName, services);

    // Instancier le compilateur
    const compiler = new RobotMlCompiler();

    // Générer le code Arduino à partir du modèle
    const generatedCode = compiler.compile(model);

    // Écrire le fichier .ino
    const generatedFilePath = fileName.replace(path.extname(fileName), '.ino');
    fs.writeFileSync(generatedFilePath, generatedCode);

    console.log(`Code Arduino généré avec succès dans : ${generatedFilePath}`);
};

export default function(): void {
    const program = new Command();

    program
        .version('0.0.1')
        .command('generate <file>')
        .description('Generates Arduino code from RobotML')
        .action(generateAction);

    program.parse(process.argv);
}