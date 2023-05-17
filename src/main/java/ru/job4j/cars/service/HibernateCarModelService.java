package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.CarModel;
import ru.job4j.cars.repository.CarModelRepository;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 13.05.2023.
 */
@Service
@AllArgsConstructor
public class HibernateCarModelService implements CarModelService {
    private final CarModelRepository carModelRepository;

    @Override
    public List<CarModel> findAll() {
        return carModelRepository.findAll();
    }

    @Override
    public Optional<CarModel> findById(int carModelId) {
        return carModelRepository.findById(carModelId);
    }
}
