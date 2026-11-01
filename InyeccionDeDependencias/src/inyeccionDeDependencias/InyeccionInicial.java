/*
Simula inyección de dependencias SIN Spring
Crea un NotificadorService que dependa de una interfaz EmailSender. 
Instáncialo manualmente pasando una implementación por constructor.
Cuando entiendas esto, entenderás por qué Spring usa @Autowired / constructor injection.
*/

package inyeccionDeDependencias;

import inyeccionDeDependencias.Implementaciones.SmtpSender;
import inyeccionDeDependencias.Interfaces.EmailSenderInterface;
import inyeccionDeDependencias.Service.NotificadorService;

public class InyeccionInicial {
    public static void main(String[] args){
        EmailSenderInterface sender = new SmtpSender();
        NotificadorService service = new NotificadorService(sender);
        service.notificar("erik@gmail.com", "Hola");
    }
}
