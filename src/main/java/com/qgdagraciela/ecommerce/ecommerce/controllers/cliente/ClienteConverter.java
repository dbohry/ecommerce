package com.qgdagraciela.ecommerce.ecommerce.controllers.cliente;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {

    public Cliente convert(ClienteDTO dto) {
        if (dto == null) return null;

        Cliente entity = new Cliente();

        entity.setSenha(dto.getSenha());
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setId(dto.getId());

        return entity;
    }

    public ClienteDTO convert(Cliente entity) {
        if (entity == null) return null;

        ClienteDTO dto = new ClienteDTO();

        dto.setSenha(entity.getSenha());
        dto.setEmail(entity.getEmail());
        dto.setNome(entity.getNome());
        dto.setId(entity.getId());

        return dto;
    }

}
