package com.dio.securiticomjwt.service;
import com.dio.securiticomjwt.entity.User;
import com.dio.securiticomjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService { //Contem as regras de negocio --> Estar de acordo com Controller
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder encoder; //Classe do JWT, para criptografar a senha,
    // para assim enviar a senha criptografada para o repositorio

    //    Construtor
    public void createUser(User user) {
        String pass = user.getPassword();
        //criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        userRepo.save(user);
    }
}
