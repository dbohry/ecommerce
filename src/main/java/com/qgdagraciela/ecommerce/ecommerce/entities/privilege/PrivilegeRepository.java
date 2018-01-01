package com.qgdagraciela.ecommerce.ecommerce.entities.privilege;

import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    Privilege findByName(String name);

}