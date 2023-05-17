package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * Oywayten 26.03.2023.
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "auto_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String description;
    private LocalDateTime created = LocalDateTime.now();
    private boolean sold;

    @ManyToOne
    @JoinColumn(name = "auto_user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<PriceHistory> priceHistory = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "participant", joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @OneToOne
    @JoinColumn(name = "post_photo_id")
    private File photo;

    public String getCreatedWithTimezone(String timezone) {
        return created.atZone(ZoneId.of(TimeZone.getDefault().getID()))
                .withZoneSameInstant(ZoneId.of(timezone))
                .format(DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd"));
    }
}
