package validar.Sin_Regex;

public class ValidarEmailV1 {
    public static boolean esEmailValido(String email){
        if(email == null || email.isEmpty()){
            return false;
        }

        //Debe de contener exactamente un arroba
        int indiceArroba = email.indexOf("@");
        int ultimaArroba = email.lastIndexOf("@");

        if(indiceArroba <= 0 || indiceArroba != ultimaArroba){
            return false; //No tiene @, esta al inicio o no hay más de una
        }

        //Separar usuario y dominio
        String usuario = email.substring(0, indiceArroba);
        String dominio = email.substring(indiceArroba + 1);

        //El dominio debe contener al menos un punto y no estar al inicio
        int indicePunto = dominio.indexOf(".");
        int ultimoPunto = dominio.lastIndexOf(".");

        if(indicePunto <= 0 || ultimoPunto == dominio.length() - 1){
            return false;
        }

        //No debe tener espacios en blanco
        if(email.contains(" ")){
            return false;
        }

        return true;
    }
}
