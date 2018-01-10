package com.qgdagraciela.ecommerce.ecommerce.service;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.ClienteRepository;
import com.qgdagraciela.ecommerce.ecommerce.entities.role.RoleRepository;
import com.qgdagraciela.ecommerce.ecommerce.service.auth.PasswordEncoder;
import com.qgdagraciela.ecommerce.ecommerce.service.cliente.ClienteService;
import com.qgdagraciela.ecommerce.ecommerce.service.role.RoleService;
import org.junit.Before;

import static org.mockito.Mockito.mock;

public class ClienteServiceTest {

    private ClienteService service;
    private ClienteRepository repository;
    private RoleService roleService;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {

        repository = mock(ClienteRepository.class);

        roleRepository = mock(RoleRepository.class);
        roleService = new RoleService(roleRepository);
        passwordEncoder = new PasswordEncoder();

        service = new ClienteService(repository, roleService, passwordEncoder);
    }

}
