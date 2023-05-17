package ru.job4j.cars.service;

import ru.job4j.cars.model.BodyType;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface BodyTypeService {
    List<BodyType> findAll();

    Optional<BodyType> findById(int bodyTypeId);
}
