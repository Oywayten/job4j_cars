package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.File;

import java.util.Map;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
@Repository
@Slf4j
@AllArgsConstructor
public class HibernateFileRepository implements FileRepository {
    public static final String FROM_FILE_WHERE_ID_IS = "FROM File AS f WHERE id = :id";
    private final CrudRepository crudRepository;

    @Override
    public Optional<File> add(File file) {
        Optional<File> fileOptional = Optional.empty();
        try {
            crudRepository.run(session -> session.save(file));
            fileOptional = Optional.of(file);
        } catch (HibernateException e) {
            log.error("Add file error", e);
        }
        return fileOptional;
    }

    @Override
    public Optional<File> findById(int id) {
        Optional<File> fileOptionall = Optional.empty();
        try {
            fileOptionall = crudRepository.optional(FROM_FILE_WHERE_ID_IS, File.class, Map.of("id", id));
        } catch (HibernateException e) {
            log.error("Find user by id error", e);
        }
        return fileOptionall;
    }
}
