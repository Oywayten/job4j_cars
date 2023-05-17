package ru.job4j.cars.repository;

import ru.job4j.cars.model.CarModel;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface CarModelRepository {
    List<CarModel> findAll();

    Optional<CarModel> findById(int carModelId);
}
