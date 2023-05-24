package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ru.job4j.cars.util.query.EngineQuery.FROM_ENGINE_ORDER_BY_NAME_ASC;
import static ru.job4j.cars.util.query.EngineQuery.FROM_ENGINE_WHERE_ID_IS;

/**
 * Oywayten 16.05.2023.
 */
@Repository
@Slf4j
@AllArgsConstructor
public class HibernateEngineRepository implements EngineRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<Engine> findAll() {
        return crudRepository.query(FROM_ENGINE_ORDER_BY_NAME_ASC, Engine.class);
    }

    @Override
    public Optional<Engine> findById(int engineId) {
        Optional<Engine> engineOptional = Optional.empty();
        try {
            engineOptional = crudRepository.optional(
                    FROM_ENGINE_WHERE_ID_IS, Engine.class, Map.of("engineId", engineId));
        } catch (HibernateException e) {
            log.error("Find engine by id error", e);
        }
        return engineOptional;
    }
}
