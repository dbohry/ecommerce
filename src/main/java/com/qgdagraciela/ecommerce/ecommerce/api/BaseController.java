package com.qgdagraciela.ecommerce.ecommerce.api;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.ClienteConverter;
import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.ClienteDTO;
import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import com.qgdagraciela.ecommerce.ecommerce.service.auth.AuthService;
import com.qgdagraciela.ecommerce.ecommerce.service.cliente.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/ecommerce/api")
public class BaseController {

    private ClienteService clienteService;
    private AuthService authService;
    private ClienteConverter converter;

    @Autowired
    public BaseController(ClienteService clienteService,
                          AuthService authService,
                          ClienteConverter converter) {
        this.clienteService = clienteService;
        this.authService = authService;
        this.converter = converter;
    }

    @ApiOperation(value = "Informe os parametros para crianção de um novo cliente", response = ClienteDTO.class)
    @PostMapping("/register")
    public ResponseEntity<ClienteDTO> register(@RequestParam("email") String email,
                                               @RequestParam("senha") String senha,
                                               @RequestParam("nome") String nome) {
        ClienteDTO dto = new ClienteDTO();
        dto.setEmail(email);
        dto.setSenha(senha);
        dto.setNome(nome);

        Cliente response = clienteService.save(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(response));
    }

    @ApiOperation(value = "Informe email e senha para se autenticar", response = String.class)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("email") String email,
                                        @RequestParam("senha") String senha) throws ServletException {
        ClienteDTO dto = new ClienteDTO();
        dto.setEmail(email);
        dto.setSenha(senha);

        String response = authService.getToken(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.OK).body("Bearer " + response);
    }

}