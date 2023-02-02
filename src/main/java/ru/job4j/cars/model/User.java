package ru.job4j.cars.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "AUTO_USER")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String login;
    @NonNull
    private String password;
}