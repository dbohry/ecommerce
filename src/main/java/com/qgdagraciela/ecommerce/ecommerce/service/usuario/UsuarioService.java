package com.qgdagraciela.ecommerce.ecommerce.service.usuario;

import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.UsuarioRepository;
import com.qgdagraciela.ecommerce.ecommerce.service.auth.PasswordEncoder;
import com.qgdagraciela.ecommerce.ecommerce.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService {

    private final String DEFAULT_ROLE = "ROLE_USER";
    private UsuarioRepository repository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository repository,
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
        Usuario actual = repository.findOne(usuario.getId());
        return repository.save(merge(usuario, actual));
    }

    public Usuario get(Long id) {
        return repository.findOne(id);
    }

    public Usuario getByEmail(String email) {
        return repository.findByEmailAndAtivoTrue(email);
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

    private Usuario merge(Usuario usuario, Usuario actual) {
        actual.setNome(usuario.getNome());
        actual.setEmail(usuario.getEmail());
        actual.setSenha(passwordEncoder.encode(usuario.getSenha()));
        actual.setCidade(usuario.getCidade());
        actual.setEstado(usuario.getEstado());
        actual.setEndereco(usuario.getEndereco());
        actual.setTelefone(usuario.getTelefone());
        actual.setCpf(usuario.getCpf());
        return actual;
    }
}
