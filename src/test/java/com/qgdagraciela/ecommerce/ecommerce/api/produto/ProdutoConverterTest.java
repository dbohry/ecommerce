package com.qgdagraciela.ecommerce.ecommerce.api.produto;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.produto.ProdutoConverter;
import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.produto.ProdutoDTO;
import com.qgdagraciela.ecommerce.ecommerce.entities.produto.Produto;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ProdutoConverterTest {

    private ProdutoConverter converter;

    @Before
    public void setUp() {
        converter = new ProdutoConverter();
    }

    @Test
    public void deveVerificarQuandoNulo() {
        assertThat(converter.convert((ProdutoDTO) null), is(nullValue()));
        assertThat(converter.convert((Produto) null), is(nullValue()));
    }

}
