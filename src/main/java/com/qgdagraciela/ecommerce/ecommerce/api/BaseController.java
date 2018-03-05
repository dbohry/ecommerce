package com.qgdagraciela.ecommerce.ecommerce.api;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.UsuarioConverter;
import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.UsuarioDTO;
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
    public ResponseEntity<UsuarioDTO> register(@RequestParam("email") String email,
                                               @RequestParam("senha") String senha,
                                               @RequestParam("nome") String nome) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(email);
        dto.setSenha(senha);
        dto.setNome(nome);

        Usuario response = usuarioService.save(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(response));
    }

    @ApiOperation(value = "Informe email e senha para se autenticar", response = String.class)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("email") String email,
                                        @RequestParam("senha") String senha) throws ServletException {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(email);
        dto.setSenha(senha);

        String response = authService.getToken(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.OK).body("Bearer " + response);
    }

    @ApiOperation(value = "Testa conexao com servico", response = String.class)
    @GetMapping("/connection")
    public ResponseEntity<String> connectionTest() {
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

}