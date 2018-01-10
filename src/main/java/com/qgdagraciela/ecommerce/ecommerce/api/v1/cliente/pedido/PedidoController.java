package com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.pedido;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente.CrudController;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PedidoController implements CrudController<PedidoDTO> {

    @Override
    public ResponseEntity<PedidoDTO> save(String token, PedidoDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<List<PedidoDTO>> getAll(String token) {
        return null;
    }

    @Override
    public ResponseEntity<PedidoDTO> get(String token, Long id) {
        return null;
    }

    @Override
    public ResponseEntity delete(String token, Long id) {
        return null;
    }

}
