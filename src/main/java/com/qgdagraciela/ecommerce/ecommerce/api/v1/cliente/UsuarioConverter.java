package com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente;

import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public Usuario convert(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario entity = new Usuario();

        entity.setSenha(dto.getSenha());
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setCidade(dto.getCidade());
        entity.setId(dto.getId());
        entity.setAtivo(Boolean.TRUE);

        return entity;
    }

    public UsuarioDTO convert(Usuario entity) {
        if (entity == null) return null;

        UsuarioDTO dto = new UsuarioDTO();

        dto.setSenha(entity.getSenha());
        dto.setEmail(entity.getEmail());
        dto.setNome(entity.getNome());
        dto.setCidade(entity.getCidade());
        dto.setId(entity.getId());

        return dto;
    }

}
