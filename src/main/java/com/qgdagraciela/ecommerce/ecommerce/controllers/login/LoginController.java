package com.qgdagraciela.ecommerce.ecommerce.controllers.login;

import com.qgdagraciela.ecommerce.ecommerce.controllers.v1.cliente.ClienteConverter;
import com.qgdagraciela.ecommerce.ecommerce.controllers.v1.cliente.ClienteDTO;
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
@RequestMapping("/ecommerce/auth")
public class LoginController {

    private ClienteService clienteService;
    private AuthService authService;
    private ClienteConverter converter;

    @Autowired
    public LoginController(ClienteService clienteService,
                           AuthService authService,
                           ClienteConverter converter) {
        this.clienteService = clienteService;
        this.authService = authService;
        this.converter = converter;
    }

    @ApiOperation(value = "Informe os parametros para crianção de um novo cliente", response = ClienteDTO.class)
    @PostMapping
    public ResponseEntity<ClienteDTO> register(@RequestParam("email") String email,
                                               @RequestParam("senha") String senha,
                                               @RequestParam("nome") String nome) {
        ClienteDTO dto = new ClienteDTO();
        dto.setEmail(email);
        dto.setSenha(senha);
        dto.setNome(nome);

        Cliente response = clienteService.save(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.OK).body(converter.convert(response));
    }

    @CrossOrigin(allowedHeaders = "*")
    @ApiOperation(value = "Inform username and password to get a valid token", response = String.class)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam("email") String email,
                                        @RequestParam("senha") String senha) throws ServletException {
        ClienteDTO dto = new ClienteDTO();
        dto.setEmail(email);
        dto.setSenha(senha);

        String response = authService.getToken(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.OK).body("Bearer " + response);
    }

}