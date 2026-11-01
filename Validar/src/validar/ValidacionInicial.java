package validar;

import validar.Regex.ValidarEmailRegex;
import validar.Sin_Regex.ValidarEmailV1;
import validar.Sin_Regex.ValidarEmailV2;

public class ValidacionInicial {
    public static void main(String[] args){
        String test1 = "usuario@ejemplo.com";
        String test2 = "correo_invalido@.com";
        String test3 = "sin-arroba.com";

        System.out.println("== V1 sin regex ==");
        System.out.println(test1 + " -> " + ValidarEmailV1.esEmailValido(test1));
        System.out.println(test2 + " -> " + ValidarEmailV1.esEmailValido(test2));
        System.out.println(test3 + " -> " + ValidarEmailV1.esEmailValido(test3));

        System.out.println("== V2 sin regex ==");
        System.out.println(test1 + " -> " + ValidarEmailV2.esEmailValido(test1));
        System.out.println(test2 + " -> " + ValidarEmailV2.esEmailValido(test2));
        System.out.println(test3 + " -> " + ValidarEmailV2.esEmailValido(test3));

        System.out.println("== V3 con regex ==");
        System.out.println(test1 + " -> " + ValidarEmailRegex.esEmailValido(test1));
        System.out.println(test2 + " -> " + ValidarEmailRegex.esEmailValido(test2));
        System.out.println(test3 + " -> " + ValidarEmailRegex.esEmailValido(test3));
    }
}
