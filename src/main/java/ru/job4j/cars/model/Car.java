package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Oywayten 31.03.2023.
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id",
            foreignKey = @ForeignKey(name = "CATEGORY_ID_FK"), nullable = false)
    @NotNull
    private Category category;

    @ManyToOne
    @JoinColumn(name = "model_id", foreignKey = @ForeignKey(name = "MODEL_ID_FK"), nullable = false)
    @NotNull
    private CarModel carModel;

    @ManyToOne()
    @JoinColumn(name = "body_type_id",
            foreignKey = @ForeignKey(name = "BODY_TYPE_ID_FK"), nullable = false)
    @NotNull
    private BodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "engine_id",
            foreignKey = @ForeignKey(name = "ENGINE_ID_FK"), nullable = false)
    @NotNull
    private Engine engine;

    @ManyToMany
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "owner_id", nullable = false, updatable = false)})
    private Set<Owner> owners = new HashSet<>();
}
