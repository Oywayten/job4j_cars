package ru.job4j.cars.service;

import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 14.05.2023.
 */
public interface UserService {
    Optional<User> add(User user);

    void update(User user);

    void delete(int userId);

    List<User> findAllOrderedById();

    Optional<User> findById(int id);

    List<User> findByLikeLogin(String key);

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);
}
