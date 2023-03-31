package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "AUTO_USER")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode
public class User {

    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NonNull
    @Column(nullable = false)
    private String login;

    @NotBlank
    @NonNull
    @Column(nullable = false)
    private String password;
}
