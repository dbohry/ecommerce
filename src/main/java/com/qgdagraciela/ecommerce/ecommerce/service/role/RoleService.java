package com.qgdagraciela.ecommerce.ecommerce.service.role;

import com.qgdagraciela.ecommerce.ecommerce.entities.role.Role;
import com.qgdagraciela.ecommerce.ecommerce.entities.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role get(String role) {
        return repository.findByName(role);
    }

}
