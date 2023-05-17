package ru.job4j.cars.repository;

import ru.job4j.cars.model.BodyType;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface BodyTypeRepository {
    List<BodyType> findAll();

    Optional<BodyType> findById(int bodyTypeId);
}
