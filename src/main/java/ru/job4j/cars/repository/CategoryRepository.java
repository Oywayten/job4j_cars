package ru.job4j.cars.repository;

import ru.job4j.cars.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface CategoryRepository {
    List<Category> findAll();

    Optional<Category> findById(int categoryId);
}
