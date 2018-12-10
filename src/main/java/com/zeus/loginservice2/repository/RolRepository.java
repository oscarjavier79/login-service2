package com.zeus.loginservice2.repository;

import com.zeus.loginservice2.repository.entity.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository  extends CrudRepository<Roles,Long> {
}
