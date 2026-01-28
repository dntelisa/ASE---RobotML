import type { ValidationAcceptor, ValidationChecks } from 'langium';
import type { RobotMlAstType, FuncDecl } from './generated/ast.js';
import type { RobotMlServices } from './robot-ml-module.js';

/**
 * Register custom validation checks.
 */
export function registerValidationChecks(services: RobotMlServices) {
    const registry = services.validation.ValidationRegistry;
    const validator = services.validation.RobotMlValidator;
    const checks: ValidationChecks<RobotMlAstType> = {
        // On associe la vérification à la déclaration de fonction
        FuncDecl: validator.checkFunctionNameStartsWithLowerCase
    };
    registry.register(checks, validator);
}

/**
 * Implementation of custom validations.
 */
export class RobotMlValidator {

    // Vérifie que le nom d'une fonction commence par une minuscule (convention)
    checkFunctionNameStartsWithLowerCase(func: FuncDecl, accept: ValidationAcceptor): void {
        if (func.name) {
            const firstChar = func.name.substring(0, 1);
            if (firstChar.toLowerCase() !== firstChar) {
                accept('warning', 'Function name should start with a lower case letter.', { node: func, property: 'name' });
            }
        }
    }

}
