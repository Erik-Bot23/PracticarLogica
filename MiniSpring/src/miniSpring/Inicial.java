/*
 Implementa un "mini Spring"
 Crea una anotación @MiServicio y una clase Contenedor que escanee clases anotadas y las instancie automáticamente.
 Entenderás cómo funciona el contenedor de Spring por dentro.
*/

package miniSpring;

import miniSpring.Implementaciones.MiniContenedor;
import miniSpring.Service.UserService;

public class Inicial {
    public static void main(String[] args) throws Exception {
        MiniContenedor ctx = new MiniContenedor();
        ctx.escanear("miniSpring.Service");

        UserService userService = ctx.getBean(UserService.class);
        userService.registrar();
        // Usuario registrado
        // Email enviado
    }
}
