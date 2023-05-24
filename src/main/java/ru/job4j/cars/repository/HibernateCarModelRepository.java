package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.CarModel;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ru.job4j.cars.util.query.CarModelQuery.FROM_CAR_MODEL_JOIN_FETCH_BRAND_ORDER_BY_CAR_MODEL_ASC_BRAND_ASC;
import static ru.job4j.cars.util.query.CarModelQuery.FROM_CAR_MODEL_WHERE_ID_IS;

/**
 * Oywayten 16.05.2023.
 */
@Repository
@Slf4j
@AllArgsConstructor
public class HibernateCarModelRepository implements CarModelRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<CarModel> findAll() {
        return crudRepository.query(
                FROM_CAR_MODEL_JOIN_FETCH_BRAND_ORDER_BY_CAR_MODEL_ASC_BRAND_ASC, CarModel.class);
    }

    @Override
    public Optional<CarModel> findById(int carModelId) {
        Optional<CarModel> carModelOptional = Optional.empty();
        try {
            carModelOptional = crudRepository.optional(
                    FROM_CAR_MODEL_WHERE_ID_IS, CarModel.class, Map.of("carModelId", carModelId));
        } catch (HibernateException e) {
            log.error("Find car model by id error", e);
        }
        return carModelOptional;
    }
}