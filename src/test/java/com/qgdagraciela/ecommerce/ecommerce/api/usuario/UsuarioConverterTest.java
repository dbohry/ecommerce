package com.qgdagraciela.ecommerce.ecommerce.api.usuario;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.UsuarioConverter;
import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.UsuarioDTO;
import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class UsuarioConverterTest {

    private static final String EMAIL = "email@email.com";
    private static final String NOME = "nome";
    private static final Long ID = 1L;

    private UsuarioConverter converter;

    @Before
    public void setUp() {
        converter = new UsuarioConverter();
    }

    @Test
    public void deveVerificarQuandoNulo() {
        assertThat(converter.convert((UsuarioDTO) null), is(nullValue()));
        assertThat(converter.convert((Usuario) null), is(nullValue()));
    }

    @Test
    public void deveConverterDTOToEntity() {
        assertThat(converter.convert(buildDTO()), is(build()));
    }

    private Usuario build() {
        Usuario c = new Usuario();

        c.setEmail(EMAIL);
        c.setNome(NOME);
        c.setId(ID);

        return c;
    }

    private UsuarioDTO buildDTO() {
        UsuarioDTO dto = new UsuarioDTO();

        dto.setEmail(EMAIL);
        dto.setNome(NOME);
        dto.setId(ID);

        return dto;
    }

}
