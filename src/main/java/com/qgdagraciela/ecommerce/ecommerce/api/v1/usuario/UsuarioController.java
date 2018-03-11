package com.qgdagraciela.ecommerce.ecommerce.api.v1.usuario;

import com.qgdagraciela.ecommerce.ecommerce.api.v1.CrudController;
import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import com.qgdagraciela.ecommerce.ecommerce.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ecommerce/api/v1/usuarios")
public class UsuarioController implements CrudController<UsuarioDTO> {

    private UsuarioService service;
    private UsuarioConverter converter;

    @Autowired
    public UsuarioController(UsuarioService service,
                             UsuarioConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@RequestHeader("authorization") String token,
                                           @RequestBody UsuarioDTO dto) {
        Usuario response = service.save(converter.convert(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(response));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@RequestHeader("authorization") String token,
                                             @PathVariable("id") Long id,
                                             @RequestBody UsuarioDTO dto) {
        Usuario usuario = converter.convert(dto);
        usuario.setId(id);

        Usuario response = service.update(usuario);
        return ResponseEntity.ok().body(converter.convert(response));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll(@RequestHeader("authorization") String token) {
        List<Usuario> response = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response.stream()
                .map(c -> converter.convert(c))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> get(@RequestHeader("authorization") String token,
                                          @PathVariable("id") Long id) {
        Usuario response = service.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(converter.convert(response));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@RequestHeader("authorization") String token,
                                 @PathVariable("id") Long id) {
        return null;
    }

}
