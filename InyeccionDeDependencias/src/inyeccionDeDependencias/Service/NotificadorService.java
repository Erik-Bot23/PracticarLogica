package inyeccionDeDependencias.Service;

import inyeccionDeDependencias.Interfaces.EmailSenderInterface;

public class NotificadorService {
    private final EmailSenderInterface emailSender;

    public NotificadorService(EmailSenderInterface emailSender){
        this.emailSender=emailSender;
    }

    public void notificar(String email, String msge){
        emailSender.enviar(email, msge);
    }
}
