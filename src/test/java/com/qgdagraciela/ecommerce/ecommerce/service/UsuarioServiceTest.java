package com.qgdagraciela.ecommerce.ecommerce.service;

import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.UsuarioRepository;
import com.qgdagraciela.ecommerce.ecommerce.entities.role.RoleRepository;
import com.qgdagraciela.ecommerce.ecommerce.service.auth.PasswordEncoder;
import com.qgdagraciela.ecommerce.ecommerce.service.usuario.UsuarioService;
import com.qgdagraciela.ecommerce.ecommerce.service.role.RoleService;
import org.junit.Before;

import static org.mockito.Mockito.mock;

public class UsuarioServiceTest {

    private UsuarioService service;
    private UsuarioRepository repository;
    private RoleService roleService;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {

        repository = mock(UsuarioRepository.class);

        roleRepository = mock(RoleRepository.class);
        roleService = new RoleService(roleRepository);
        passwordEncoder = new PasswordEncoder();

        service = new UsuarioService(repository, roleService, passwordEncoder);
    }

}
