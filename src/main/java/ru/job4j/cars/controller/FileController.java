package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.service.FileService;

import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
@RestController
@RequestMapping("/files")
@AllArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<FileDto> fileDtoOptional = fileService.findFileById(id);
        if (fileDtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        FileDto fileDto = fileDtoOptional.get();
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(fileDto.getContent());
    }
}
