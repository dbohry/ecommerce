package com.qgdagraciela.ecommerce.ecommerce.service.auth;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.login.LoginDTO;
import com.qgdagraciela.ecommerce.ecommerce.api.v1.usuario.UsuarioConverter;
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
    private UsuarioConverter converter;
    private AuthValidator validator;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UsuarioService usuarioService,
                       UsuarioConverter converter,
                       AuthValidator validator,
                       PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.converter = converter;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginDTO getAuthentication(Usuario usuario) throws ServletException {
        validator.validate(usuario);

        String hash = passwordEncoder.encode(usuario.getSenha());
        Usuario user = usuarioService.findByLogin(usuario.getEmail(), hash);

        if (user == null) throw new ServletException("Usuario não encontrado.");

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        String token = Jwts.builder()
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .signWith(signatureAlgorithm, signingKey)
                .compact();

        LoginDTO login = new LoginDTO();
        login.setToken("Bearer " + token);
        login.setUsuario(converter.convert(usuarioService.getByEmail(user.getEmail())));

        return login;
    }

}