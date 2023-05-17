package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.BodyType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ru.job4j.cars.util.query.BodyTypeQuery.FROM_BODY_ORDER_BY_NAME_ASC;
import static ru.job4j.cars.util.query.BodyTypeQuery.FROM_BODY_TYPE_WHERE_ID_IS;

/**
 * Oywayten 16.05.2023.
 */
@Repository
@Slf4j
@AllArgsConstructor
public class HibernateBodyTypeRepository implements BodyTypeRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<BodyType> findAll() {
        return crudRepository.query(FROM_BODY_ORDER_BY_NAME_ASC, BodyType.class);
    }

    @Override
    public Optional<BodyType> findById(int bodyTypeId) {
        Optional<BodyType> bodyTypeOptional = Optional.empty();
        try {
            bodyTypeOptional = crudRepository.optional(FROM_BODY_TYPE_WHERE_ID_IS, BodyType.class, Map.of("bodyTypeId", bodyTypeId));
        } catch (HibernateException e) {
            log.error("Find body type by id error", e);
        }
        return bodyTypeOptional;
    }
}
