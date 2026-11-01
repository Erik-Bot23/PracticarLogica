package validar.Regex;

import java.util.regex.Pattern;

public class ValidarEmailRegex {
    private static final Pattern EMAIL = Pattern.compile(
        "^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$"
    );

    public static boolean esEmailValido(String email){
        return email != null && EMAIL.matcher(email).matches();
    }

}
