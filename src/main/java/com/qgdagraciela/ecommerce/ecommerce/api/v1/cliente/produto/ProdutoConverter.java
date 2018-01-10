package com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.produto;

import com.qgdagraciela.ecommerce.ecommerce.entities.produto.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConverter {

    public Produto convert(ProdutoDTO dto) {
        if (dto == null) return null;
        return new Produto(dto.getNome());
    }

    public ProdutoDTO convert(Produto bo) {
        if (bo == null) return null;
        return new ProdutoDTO(bo.getId(), bo.getNome());
    }

}
