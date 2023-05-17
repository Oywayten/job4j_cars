package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Category;
import ru.job4j.cars.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 13.05.2023.
 */
@Service
@AllArgsConstructor
public class HibernateCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
