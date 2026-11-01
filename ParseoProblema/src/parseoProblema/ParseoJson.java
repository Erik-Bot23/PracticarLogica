package parseoProblema;

public class ParseoJson {

    public static String extraerValor(String json, String clave){
        if(json == null || clave == null) return null;

        // Buscamos la clave CON sus comillas: "nombre"
        String patron = "\"" + clave + "\"";
        int idx = json.indexOf(patron);
        if(idx == -1) return null;

        // Buscamos los dos puntos que van después de la clave
        int dosPuntos = json.indexOf(':', idx + patron.length());
        if(dosPuntos == -1) return null;

        // Saltamos espacios en blanco después de los dos puntos
        int inicio = dosPuntos + 1;
        while(inicio < json.length() && Character.isWhitespace(json.charAt(inicio))){
            inicio++;
        }
        if(inicio >= json.length()) return null;

        // Caso 1: el valor viene entre comillas -> {"nombre":"Ana"}
        if(json.charAt(inicio) == '"'){
            int fin = json.indexOf('"', inicio + 1);
            if(fin == -1) return null;
            return json.substring(inicio + 1, fin);
        }

        // Caso 2: el valor es un número, booleano o null -> {"edad":25}
        int fin = inicio;
        while(fin < json.length() && json.charAt(fin) != ',' && json.charAt(fin) != '}'){
            fin++;
        }
        return json.substring(inicio, fin).trim();
    }
}
