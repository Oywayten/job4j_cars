package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Category;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ru.job4j.cars.util.query.CategoryQuery.FROM_CATEGORY_ORDER_BY_NAME_ASC;
import static ru.job4j.cars.util.query.CategoryQuery.FROM_CATEGORY_WHERE_ID_IS;

/**
 * Oywayten 16.05.2023.
 */
@Repository
@Slf4j
@AllArgsConstructor
public class HibernateCategoryRepository implements CategoryRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<Category> findAll() {
        return crudRepository.query(FROM_CATEGORY_ORDER_BY_NAME_ASC, Category.class);
    }

    @Override
    public Optional<Category> findById(int categoryId) {
        Optional<Category> categoryOptional = Optional.empty();
        try {
            categoryOptional = crudRepository.optional(FROM_CATEGORY_WHERE_ID_IS, Category.class, Map.of("categoryId", categoryId));
        } catch (HibernateException e) {
            log.error("Find category by id error", e);
        }
        return categoryOptional;
    }
}
