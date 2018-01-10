package com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface CrudController<T> {

    ResponseEntity<T> save(@RequestHeader("authorization") String token, @RequestBody T dto);

    ResponseEntity<List<T>> getAll(@RequestHeader("authorization") String token);

    ResponseEntity<T> get(@RequestHeader("authorization") String token, @PathVariable("id") Long id);

    ResponseEntity delete(@RequestHeader("authorization") String token, @PathVariable("id") Long id);

}
