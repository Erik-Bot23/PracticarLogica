package validar.Sin_Regex;

public class ValidarEmailV2 {
    public static boolean esEmailValido(String email){
        if(email == null || email.isEmpty()){
            return false;
        }

        int at = email.indexOf('@');
        int punto = email.lastIndexOf('.');

        return at > 0 && at < email.length() -1 && punto > at + 1
                        && punto < email.length() - 1 && email.indexOf(' ') == -1;
        
    }
}
