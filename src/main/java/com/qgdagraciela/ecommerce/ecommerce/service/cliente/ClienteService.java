package com.qgdagraciela.ecommerce.ecommerce.service.cliente;

import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.UsuarioRepository;
import com.qgdagraciela.ecommerce.ecommerce.service.auth.PasswordEncoder;
import com.qgdagraciela.ecommerce.ecommerce.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ClienteService {

    private final String DEFAULT_ROLE = "ROLE_USER";
    private UsuarioRepository repository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ClienteService(UsuarioRepository repository,
                          RoleService roleService,
                          PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario save(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setRoles(Collections.singletonList(roleService.get(DEFAULT_ROLE)));
        usuario.setAtivo(Boolean.TRUE);
        return repository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    public Usuario get(Long id) {
        return repository.findOne(id);
    }

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario findByLogin(String email, String senha) {
        return repository.findByEmailAndSenhaAndAtivoTrue(email, senha);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
