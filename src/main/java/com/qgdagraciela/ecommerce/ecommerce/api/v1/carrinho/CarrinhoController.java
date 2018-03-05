package com.qgdagraciela.ecommerce.ecommerce.api.v1.carrinho;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.CrudController;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/api/v1/carrinhos")
public class CarrinhoController implements CrudController<CarrinhoDTO> {

    @Override
    @ApiOperation(value = "Salva carrinho com lista de pedidos.", response = CarrinhoDTO.class)
    @PostMapping
    public ResponseEntity<CarrinhoDTO> save(@RequestHeader("authorization") String token,
                                            @RequestBody CarrinhoDTO dto) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CarrinhoDTO> update(@RequestHeader("authorization") String token,
                                              @PathVariable("id") Long id,
                                              @RequestBody CarrinhoDTO dto) {
        return null;
    }

    @Override
    @ApiOperation(value = "Retorna lista de todos os carrinhos.", response = CarrinhoDTO[].class)
    @GetMapping
    public ResponseEntity<List<CarrinhoDTO>> getAll(@RequestHeader("authorization") String token) {
        return null;
    }

    @Override
    @ApiOperation(value = "Retorna lista de um carrinho por id.", response = CarrinhoDTO.class)
    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoDTO> get(@RequestHeader("authorization") String token,
                                           @PathVariable("id") Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestHeader("authorization") String token,
                                 @PathVariable("id") Long id) {
        return null;
    }

}
