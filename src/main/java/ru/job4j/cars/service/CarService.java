package ru.job4j.cars.service;

import ru.job4j.cars.model.Car;

import java.util.Optional;

/**
 * Oywayten 14.05.2023.
 */
public interface CarService {
    Optional<Car> add(Car car);
}
