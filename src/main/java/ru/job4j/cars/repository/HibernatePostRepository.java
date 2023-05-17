package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ru.job4j.cars.util.query.PostQuery.*;

/**
 * Oywayten 01.04.2023.
 */
@Repository
@AllArgsConstructor
public class HibernatePostRepository implements PostRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<Post> findAll() {
        return crudRepository.query(FROM_POST_ORDER_BY_CREATED_ASC, Post.class);
    }

    @Override
    public List<Post> findAllForLastDay() {
        return crudRepository
                .query(FROM_POST_WHERE_CREATED_MORE_THAN_DATE_ORDER_BY_CREATED_ASC,
                        Post.class, Map.of("date", LocalDateTime.now().minusDays(1).truncatedTo(ChronoUnit.SECONDS)));
    }

    @Override
    public List<Post> findAllWithPhoto() {
        return crudRepository.query(FROM_POST_WHERE_PHOTO_IS_NOT_NULL_ORDER_BY_CREATED_ASC, Post.class);
    }

    @Override
    public List<Post> findAllByBrand(String brand) {
        return crudRepository.query(FROM_POST_WHERE_CAR_MODEL_BRAND_IS, Post.class, Map.of("brand", brand));
    }

    @Override
    public Optional<Post> findById(Long id) {
        return crudRepository.optional(FROM_POST_WHERE_ID_IS, Post.class, Map.of("id", id));
    }

    @Override
    public Optional<Post> add(Post post) {
        return crudRepository.tx(session -> {
            session.persist(post);
            return Optional.ofNullable(post);
        });
    }

    @Override
    public boolean setPostStatusSold(Long postId, int userId) {
        return crudRepository.run(
                UPDATE_POST_SET_SOLD_TRUE_WHERE_POST_ID_AND_USER_ID_IS, Map.of("postId", postId, "userId", userId)) == 1;
    }
}
