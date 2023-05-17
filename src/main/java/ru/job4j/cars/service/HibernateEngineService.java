package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.repository.EngineRepository;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 13.05.2023.
 */
@Service
@AllArgsConstructor
public class HibernateEngineService implements EngineService {
    private final EngineRepository engineRepository;

    @Override
    public List<Engine> findAll() {
        return engineRepository.findAll();
    }

    @Override
    public Optional<Engine> findById(int engineId) {
        return engineRepository.findById(engineId);
    }
}
