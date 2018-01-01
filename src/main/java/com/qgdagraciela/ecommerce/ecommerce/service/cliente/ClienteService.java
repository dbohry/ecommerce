package com.qgdagraciela.ecommerce.ecommerce.service.cliente;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.ClienteRepository;
import com.qgdagraciela.ecommerce.ecommerce.service.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ClienteService(ClienteRepository repository,
                          PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Cliente save(Cliente cliente) {
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
