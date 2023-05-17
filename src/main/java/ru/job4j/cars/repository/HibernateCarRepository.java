package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;

import java.util.Optional;

/**
 * Oywayten 31.03.2023.
 */
@Repository
@Slf4j
@AllArgsConstructor
public class HibernateCarRepository implements CarRepository {

    private final CrudRepository crudRepository;

    @Override
    public Optional<Car> add(Car car) {
        Optional<Car> carOptional = Optional.empty();
        try {
            crudRepository.run(session -> session.save(car));
            carOptional = Optional.of(car);
        } catch (HibernateException e) {
            log.error("Add car error", e);
        }
        return carOptional;
    }

}
