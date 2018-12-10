package com.zeus.loginservice2.repository;

import com.zeus.loginservice2.repository.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

  public User findByUsername(String username);
}
