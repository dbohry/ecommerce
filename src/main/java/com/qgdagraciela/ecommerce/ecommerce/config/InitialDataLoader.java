package com.qgdagraciela.ecommerce.ecommerce.config;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.ClienteRepository;
import com.qgdagraciela.ecommerce.ecommerce.entities.privilege.Privilege;
import com.qgdagraciela.ecommerce.ecommerce.entities.privilege.PrivilegeRepository;
import com.qgdagraciela.ecommerce.ecommerce.entities.role.Role;
import com.qgdagraciela.ecommerce.ecommerce.entities.role.RoleRepository;
import com.qgdagraciela.ecommerce.ecommerce.service.auth.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup) return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Cliente user = new Cliente();
        user.setSenha(passwordEncoder.encode("teste"));
        user.setNome("administrador");
        user.setEmail("administrador@teste.com");
        user.setRoles(Collections.singletonList(adminRole));
        user.setAtivo(true);
        clienteRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRoleIfNotFound(
            String name, List<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}