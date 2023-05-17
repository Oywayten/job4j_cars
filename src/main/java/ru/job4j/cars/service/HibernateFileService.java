package ru.job4j.cars.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.File;
import ru.job4j.cars.repository.FileRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

/**
 * Oywayten 17.05.2023.
 */
@Service
public class HibernateFileService implements FileService {

    private final FileRepository fileRepository;

    private final String storageDirectory;

    public HibernateFileService(FileRepository fileRepository, @Value("${file.directory}") String storageDirectory) {
        this.fileRepository = fileRepository;
        this.storageDirectory = storageDirectory;
    }

    @Override
    public Optional<File> add(FileDto fileDto) {
        String path = getNewFilePath(fileDto.getName());
        writeFileBytes(path, fileDto.getContent());
        return fileRepository.add(new File(fileDto.getName(), path));
    }

    private String getNewFilePath(String sourceName) {
        return storageDirectory + java.io.File.separator + UUID.randomUUID() + sourceName;
    }

    private void writeFileBytes(String stringPath, byte[] content) {
        try {
            Path path = Path.of(stringPath);
            Files.createDirectories(path.getParent());
            Files.write(path, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<FileDto> findFileById(int id) {
        Optional<File> fileOptional = fileRepository.findById(id);
        if (fileOptional.isEmpty()) {
            return Optional.empty();
        }
        File file = fileOptional.get();
        byte[] content = readFileAsBytes(file.getPath());
        return Optional.of(new FileDto(file.getName(), content));
    }

    private byte[] readFileAsBytes(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
