package com.qgdagraciela.ecommerce.ecommerce.service.auth;

import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import com.qgdagraciela.ecommerce.ecommerce.service.usuario.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@Service
public class AuthService {

    public static final String SECRET_KEY = "secret";
    private UsuarioService usuarioService;
    private AuthValidator validator;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UsuarioService usuarioService,
                       AuthValidator validator,
                       PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
    }

    public String getToken(Usuario usuario) throws ServletException {
        validator.validate(usuario);

        String hash = passwordEncoder.encode(usuario.getSenha());
        Usuario user = usuarioService.findByLogin(usuario.getEmail(), hash);

        if (user == null) throw new ServletException("Usuario não encontrado.");

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .signWith(signatureAlgorithm, signingKey)
                .compact();
    }

}