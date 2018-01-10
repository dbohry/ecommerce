package com.qgdagraciela.ecommerce.ecommerce.api.cliente;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.cliente.ClienteConverter;
import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.cliente.ClienteDTO;
import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ClienteConverterTest {

    private static final String EMAIL = "email@email.com";
    private static final String NOME = "nome";
    private static final Long ID = 1L;

    private ClienteConverter converter;

    @Before
    public void setUp() {
        converter = new ClienteConverter();
    }

    @Test
    public void deveVerificarQuandoNulo() {
        assertThat(converter.convert((ClienteDTO) null), is(nullValue()));
        assertThat(converter.convert((Cliente) null), is(nullValue()));
    }

    @Test
    public void deveConverterDTOToEntity() {
        assertThat(converter.convert(buildDTO()), is(build()));
    }

    private Cliente build() {
        Cliente c = new Cliente();

        c.setEmail(EMAIL);
        c.setNome(NOME);
        c.setId(ID);

        return c;
    }

    private ClienteDTO buildDTO() {
        ClienteDTO dto = new ClienteDTO();

        dto.setEmail(EMAIL);
        dto.setNome(NOME);
        dto.setId(ID);

        return dto;
    }

}
