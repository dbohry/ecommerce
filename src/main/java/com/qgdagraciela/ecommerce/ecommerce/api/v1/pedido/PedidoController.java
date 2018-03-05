package com.qgdagraciela.ecommerce.ecommerce.api.v1.pedido;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.CrudController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/api/v1/pedidos")
public class PedidoController implements CrudController<PedidoDTO> {

    @Override
    @PostMapping
    public ResponseEntity<PedidoDTO> save(@RequestHeader("authorization") String token,
                                          @RequestBody PedidoDTO dto) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> update(@RequestHeader("authorization") String token,
                                            @PathVariable("id") Long id,
                                            @RequestBody PedidoDTO dto) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll(@RequestHeader("authorization") String token) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> get(@RequestHeader("authorization") String token,
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
