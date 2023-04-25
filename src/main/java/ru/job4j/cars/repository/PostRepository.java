package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * Oywayten 01.04.2023.
 */
@Slf4j
@Repository
@AllArgsConstructor
public class PostRepository {

    private static final String GET_ALL = "FROM Post p";
    private static final String LAST_DAY = "WHERE p.created >= :date";
    private static final String HAS_PHOTO = "WHERE p.photo IS NOT NULL";
    private static final String BY_BRAND = "JOIN p.car c WHERE c.name = :brand%%";
    private static final String ORDER_ASC_BY_CREATED = "ORDER BY p.created ASC";
    private static final String GET_ALL_FROM_LAST_DAY_ASC = String.format("%s %s %s", GET_ALL, LAST_DAY, ORDER_ASC_BY_CREATED);
    private static final String GET_ALL_WITH_PHOTO_ASC = String.format("%s %s %s", GET_ALL, HAS_PHOTO, ORDER_ASC_BY_CREATED);
    private static final String GET_ALL_BY_BRAND_ASC = String.format("%s %s %s", GET_ALL, BY_BRAND, ORDER_ASC_BY_CREATED);
    private final CrudRepository crudRepository;

    public List<Post> getAllFromLastDay() {
        return crudRepository
                .query(GET_ALL_FROM_LAST_DAY_ASC,
                        Post.class, Map.of("date", LocalDateTime.now().minusDays(1).truncatedTo(ChronoUnit.SECONDS)));
    }

    public List<Post> getAllWithPhoto() {
        return crudRepository.query(GET_ALL_WITH_PHOTO_ASC, Post.class);
    }

    public List<Post> getAllByBrand(String brand) {
        return crudRepository.query(GET_ALL_BY_BRAND_ASC, Post.class, Map.of("brand", brand));
    }
}
