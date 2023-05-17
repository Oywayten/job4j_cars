package ru.job4j.cars.repository;

import ru.job4j.cars.model.Car;

import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface CarRepository {
    Optional<Car> add(Car car);
}
