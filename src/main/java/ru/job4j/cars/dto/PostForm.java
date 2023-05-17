package ru.job4j.cars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Oywayten 16.05.2023.
 */
@AllArgsConstructor
@Getter
public class PostForm {
    private final int categoryId;
    private final int carModelId;
    private final int bodyTypeId;
    private final int engineId;
    private final String description;
}
