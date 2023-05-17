package ru.job4j.cars.service;

import ru.job4j.cars.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(int categoryId);
}
