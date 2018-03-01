package com.qgdagraciela.ecommerce.ecommerce.entities.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailAndSenhaAndAtivoTrue(String email, String senha);

}
