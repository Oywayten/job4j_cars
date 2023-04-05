package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Oywayten 01.04.2023.
 */
@Repository
@AllArgsConstructor
public class PostRepository {

    private final CrudRepository crudRepository;

    
}
