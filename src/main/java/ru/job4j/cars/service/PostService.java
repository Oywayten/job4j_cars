package ru.job4j.cars.service;

import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 14.05.2023.
 */
public interface PostService {
    Optional<Post> add(Post post);

    List<Post> findAll();

    List<Post> findAllForLastDay();

    List<Post> findAllWithPhoto();

    List<Post> findAllByBrand(String brand);

    boolean setPostStatusSold(Long postId, int userId);
}
