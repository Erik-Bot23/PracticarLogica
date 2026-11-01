package miniSpring.Service;

import miniSpring.Interfaces.MiServicio;

@MiServicio
public class UserService {
    private final EmailService emailService;

    public UserService(EmailService emailService){
        this.emailService = emailService;
    }

    public void registrar(){
        System.out.println("Usuario registrado");
        emailService.enviar();
    }
}
