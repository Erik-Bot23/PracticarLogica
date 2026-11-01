package inyeccionDeDependencias.Implementaciones;

import inyeccionDeDependencias.Interfaces.EmailSenderInterface;

public class SmtpSender implements EmailSenderInterface {
    public void enviar(String destino, String mensaje){
        System.out.println("SMTP -> " + destino + ": " + mensaje);
    }
}
