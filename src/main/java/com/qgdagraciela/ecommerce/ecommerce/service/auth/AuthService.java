package com.qgdagraciela.ecommerce.ecommerce.service.auth;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import com.qgdagraciela.ecommerce.ecommerce.service.PasswordEncoder;
import com.qgdagraciela.ecommerce.ecommerce.service.cliente.ClienteService;
import com.qgdagraciela.ecommerce.ecommerce.validator.AuthValidator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.Date;

@Service
public class AuthService {

    private ClienteService clienteService;
    private AuthValidator validator;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(ClienteService clienteService,
                       AuthValidator validator,
                       PasswordEncoder passwordEncoder) {
        this.clienteService = clienteService;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
    }

    public String getToken(Cliente login) throws ServletException {
        validator.validate(login);

        String hash = passwordEncoder.encode(login.getSenha());
        Cliente user = clienteService.findByLogin(login.getEmail(), hash);

        if (user == null) throw new ServletException("Cliente não encontrado.");

        return Jwts.builder()
                .setSubject(login.getEmail())
                .claim("roles", user.getRoles().toString())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
    }

}