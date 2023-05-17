package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 14.05.2023.
 */
@Service
@AllArgsConstructor
public class HibernateUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> add(User user) {
        return userRepository.add(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(int userId) {
        userRepository.delete(userId);
    }

    @Override
    public List<User> findAllOrderedById() {
        return userRepository.findAllOrderedById();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByLikeLogin(String key) {
        return userRepository.findByLikeLogin(key);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
}
