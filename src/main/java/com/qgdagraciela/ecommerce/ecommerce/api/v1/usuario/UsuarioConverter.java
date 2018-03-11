package com.qgdagraciela.ecommerce.ecommerce.api.v1.usuario;

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
        entity.setEndereco(dto.getEndereco());
        entity.setCidade(dto.getCidade());
        entity.setEstado(dto.getEstado());
        entity.setTelefone(dto.getTelefone());
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
        dto.setEndereco(entity.getEndereco());
        dto.setCidade(entity.getCidade());
        dto.setEstado(entity.getEstado());
        dto.setTelefone(entity.getTelefone());
        dto.setCpf(entity.getCpf());
        dto.setId(entity.getId());

        return dto;
    }

}
