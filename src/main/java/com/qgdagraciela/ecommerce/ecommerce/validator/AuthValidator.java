package com.qgdagraciela.ecommerce.ecommerce.validator;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletException;

@Component
public class AuthValidator {

    public void validate(Cliente login) throws ServletException {
        if (ObjectUtils.isEmpty(login) || (login.getEmail() == null || login.getSenha() == null)) {
            throw new ServletException("Preencha email e senha.");
        }
    }

}