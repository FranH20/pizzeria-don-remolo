package com.franhc.pizzeria.remolo.v1.repositories;

import com.franhc.pizzeria.remolo.v1.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
