package com.qgdagraciela.ecommerce.ecommerce.controllers.v1.cliente;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import com.qgdagraciela.ecommerce.ecommerce.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ecommerce/api/v1/clientes")
public class ClienteController {

    private ClienteService service;
    private ClienteConverter converter;

    @Autowired
    public ClienteController(ClienteService service,
                             ClienteConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> get(@RequestHeader("authorization") String token) {
        List<Cliente> response = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response.stream()
                .map(c -> converter.convert(c))
                .collect(Collectors.toList()));
    }

}
