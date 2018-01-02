package com.qgdagraciela.ecommerce.ecommerce.service.cliente;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.ClienteRepository;
import com.qgdagraciela.ecommerce.ecommerce.entities.role.RoleRepository;
import com.qgdagraciela.ecommerce.ecommerce.service.auth.PasswordEncoder;
import com.qgdagraciela.ecommerce.ecommerce.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ClienteService {

    private final String DEFAULT_ROLE = "ROLE_USER";
    private ClienteRepository repository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ClienteService(ClienteRepository repository,
                          RoleService roleService,
                          PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public Cliente save(Cliente cliente) {
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        cliente.setRoles(Collections.singletonList(roleService.get(DEFAULT_ROLE)));
        cliente.setAtivo(Boolean.TRUE);
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        return repository.save(cliente);
    }

    public Cliente get(Long id) {
        return repository.findOne(id);
    }

    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Cliente findByLogin(String email, String senha) {
        return repository.findByEmailAndSenhaAndAtivoTrue(email, senha);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
