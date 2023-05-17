package ru.job4j.cars.service;

import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.File;

import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface FileService {
    Optional<File> add(FileDto fileDto);

    Optional<FileDto> findFileById(int id);
}
