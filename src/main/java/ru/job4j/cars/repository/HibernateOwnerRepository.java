package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Oywayten 31.03.2023.
 */
@Repository
@AllArgsConstructor
public class HibernateOwnerRepository implements OwnerRepository {

    private final CrudRepository crudRepository;

}
