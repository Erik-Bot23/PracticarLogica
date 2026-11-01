package parseoProblema;

public class Inicial {
    public static void main(String[] args){
        String json = "{\"nombre\":\"Ana\",\"edad\":25,\"activo\":true}";

        System.out.println(ParseoJson.extraerValor(json, "nombre")); // Ana
        System.out.println(ParseoJson.extraerValor(json, "edad"));   // 25
        System.out.println(ParseoJson.extraerValor(json, "activo")); // true
        System.out.println(ParseoJson.extraerValor(json, "apellido")); // null
    }
}
