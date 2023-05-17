package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.repository.CarRepository;

import java.util.Optional;

/**
 * Oywayten 14.05.2023.
 */
@Service
@AllArgsConstructor
public class HibernateCarService implements CarService {

    private final CarRepository carRepository;

    @Override
    public Optional<Car> add(Car car) {
        return carRepository.add(car);
    }
}
