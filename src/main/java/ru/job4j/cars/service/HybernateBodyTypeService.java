package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.BodyType;
import ru.job4j.cars.repository.BodyTypeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 13.05.2023.
 */
@Service
@AllArgsConstructor
public class HybernateBodyTypeService implements BodyTypeService {
    private final BodyTypeRepository bodyTypeRepository;

    @Override
    public List<BodyType> findAll() {
        return bodyTypeRepository.findAll();
    }

    @Override
    public Optional<BodyType> findById(int bodyTypeId) {
        return bodyTypeRepository.findById(bodyTypeId);
    }
}
