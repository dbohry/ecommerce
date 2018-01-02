package com.qgdagraciela.ecommerce.ecommerce.service.auth;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import com.qgdagraciela.ecommerce.ecommerce.service.cliente.ClienteService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
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

    public String getToken(Cliente cliente) throws ServletException {
        validator.validate(cliente);

        String hash = passwordEncoder.encode(cliente.getSenha());
        Cliente user = clienteService.findByLogin(cliente.getEmail(), hash);

        if (user == null) throw new ServletException("Cliente não encontrado.");

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("secret");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .signWith(signatureAlgorithm, signingKey)
                .compact();
    }

}