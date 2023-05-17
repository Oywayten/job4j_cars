package ru.job4j.cars.repository;

import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface PostRepository {
    List<Post> findAll();

    List<Post> findAllForLastDay();

    List<Post> findAllWithPhoto();

    List<Post> findAllByBrand(String brand);

    Optional<Post> findById(Long id);

    Optional<Post> add(Post post);

    boolean setPostStatusSold(Long postId, int userId);
}
