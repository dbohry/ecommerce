package com.qgdagraciela.ecommerce.ecommerce.api;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.login.LoginDTO;
import com.qgdagraciela.ecommerce.ecommerce.api.v1.usuario.UsuarioConverter;
import com.qgdagraciela.ecommerce.ecommerce.api.v1.usuario.UsuarioDTO;
import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import com.qgdagraciela.ecommerce.ecommerce.service.auth.AuthService;
import com.qgdagraciela.ecommerce.ecommerce.service.usuario.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/ecommerce/api")
public class BaseController {

    private UsuarioService usuarioService;
    private AuthService authService;
    private UsuarioConverter converter;

    @Autowired
    public BaseController(UsuarioService usuarioService,
                          AuthService authService,
                          UsuarioConverter converter) {
        this.usuarioService = usuarioService;
        this.authService = authService;
        this.converter = converter;
    }

    @ApiOperation(value = "Informe os parametros para crianção de um novo usuario", response = UsuarioDTO.class)
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody UsuarioDTO dto) {
        Usuario response = usuarioService.save(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(response));
    }

    @ApiOperation(value = "Informe email e senha para se autenticar", response = LoginDTO.class)
    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestParam("email") String email,
                                          @RequestParam("senha") String senha) throws ServletException {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(email);
        dto.setSenha(senha);

        LoginDTO response = authService.getAuthentication(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}