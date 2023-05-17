package ru.job4j.cars.repository;

import ru.job4j.cars.model.File;

import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface FileRepository {
    Optional<File> add(File file);

    Optional<File> findById(int id);
}
