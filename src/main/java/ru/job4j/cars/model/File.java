package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Oywayten 17.05.2023.
 */
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotBlank
    @NonNull
    @Column(nullable = false)
    private String name;

    @NotBlank
    @NonNull
    @Column(nullable = false)
    private String path;
}
