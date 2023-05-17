package ru.job4j.cars.repository;

import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 17.05.2023.
 */
public interface UserRepository {
    Optional<User> add(User user);

    void update(User user);

    void delete(int userId);

    List<User> findAllOrderedById();

    Optional<User> findById(int id);

    List<User> findByLikeLogin(String key);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);
}
