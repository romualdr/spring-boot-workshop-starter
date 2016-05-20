package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by romuald on 20/05/2016.
 */
public interface UserRepository extends JpaRepository<Person, String> {

    List<Person> findByNameLikeIgnoreCase(String name);

}
