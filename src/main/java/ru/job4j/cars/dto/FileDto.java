package ru.job4j.cars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Oywayten 17.05.2023.
 */
@AllArgsConstructor
@Getter
@Setter
public class FileDto {
    private String name;
    private byte[] content;
}
