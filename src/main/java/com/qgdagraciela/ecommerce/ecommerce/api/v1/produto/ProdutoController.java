package com.qgdagraciela.ecommerce.ecommerce.api.v1.produto;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.CrudController;
import com.qgdagraciela.ecommerce.ecommerce.entities.produto.Produto;
import com.qgdagraciela.ecommerce.ecommerce.service.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ecommerce/api/v1/produtos")
public class ProdutoController implements CrudController<ProdutoDTO> {

    private ProdutoService service;
    private ProdutoConverter converter;

    @Autowired
    public ProdutoController(ProdutoService service,
                             ProdutoConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Override
    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestHeader("authorization") String token,
                                           @RequestBody ProdutoDTO dto) {

        Produto response = service.save(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(response));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@RequestHeader("authorization") String token,
                                             @PathVariable("id") Long id,
                                             @RequestBody ProdutoDTO dto) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll(@RequestHeader("authorization") String token) {
        List<Produto> response = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response.stream()
                .map(c -> converter.convert(c))
                .collect(Collectors.toList()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> get(@RequestHeader("authorization") String token,
                                          @PathVariable("id") Long id) {
        Produto response = service.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(converter.convert(response));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestHeader("authorization") String token,
                                 @PathVariable("id") Long id) {

        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
