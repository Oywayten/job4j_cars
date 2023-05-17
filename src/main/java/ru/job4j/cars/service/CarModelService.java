package ru.job4j.cars.service;

import ru.job4j.cars.model.CarModel;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface CarModelService {
    List<CarModel> findAll();

    Optional<CarModel> findById(int carModelId);
}
