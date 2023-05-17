package ru.job4j.cars.service;

import ru.job4j.cars.model.Engine;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface EngineService {
    List<Engine> findAll();

    Optional<Engine> findById(int engineId);
}
