package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "AUTO_USER", uniqueConstraints = {@UniqueConstraint(columnNames = "login")})
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @EqualsAndHashCode.Include
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

    @Column(name = "user_zone", nullable = false)
    private String timezone;
}
