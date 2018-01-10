package com.qgdagraciela.ecommerce.ecommerce.service.produto;

import com.qgdagraciela.ecommerce.ecommerce.entities.produto.Produto;
import com.qgdagraciela.ecommerce.ecommerce.entities.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public Produto get(Long id) {
        return repository.findOne(id);
    }

    public List<Produto> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
