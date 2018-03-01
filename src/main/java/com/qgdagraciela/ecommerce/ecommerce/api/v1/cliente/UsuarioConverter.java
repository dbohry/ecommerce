package com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente;

import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public Usuario convert(ClienteDTO dto) {
        if (dto == null) return null;

        Usuario entity = new Usuario();

        entity.setSenha(dto.getSenha());
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setId(dto.getId());

        return entity;
    }

    public ClienteDTO convert(Usuario entity) {
        if (entity == null) return null;

        ClienteDTO dto = new ClienteDTO();

        dto.setSenha(entity.getSenha());
        dto.setEmail(entity.getEmail());
        dto.setNome(entity.getNome());
        dto.setId(entity.getId());

        return dto;
    }

}
