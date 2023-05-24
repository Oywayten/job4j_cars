package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.User;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ru.job4j.cars.util.query.UserQuery.*;

@Repository
@Slf4j
@AllArgsConstructor
public class HybernateUserRepository implements UserRepository {

    private final CrudRepository crudRepository;

    @Override
    public Optional<User> add(User user) {
        Optional<User> userOptional = Optional.empty();
        try {
            crudRepository.run(session -> session.save(user));
            userOptional = Optional.of(user);
        } catch (HibernateException e) {
            log.error("Add user error", e);
        }
        return userOptional;
    }

    @Override
    public void update(User user) {
        try {
            crudRepository.run(session -> session.merge(user));
        } catch (HibernateException e) {
            log.error("Update user error", e);
        }
    }

    @Override
    public void delete(int userId) {
        try {
            crudRepository.run(DELETE_BY_ID, Map.of("id", userId));
        } catch (HibernateException e) {
            log.error("Delete user error", e);
        }
    }

    @Override
    public List<User> findAllOrderedById() {
        List<User> users = new ArrayList<>();
        try {
            users = crudRepository.query(FROM_USER_ORDER_BY_ID_ASC, User.class);
        } catch (HibernateException e) {
            log.error("Find all users error", e);
        }
        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> userOptional = Optional.empty();
        try {
            userOptional =
                    crudRepository.optional(FROM_USER_WHERE_ID_IS, User.class, Map.of("id", id));
        } catch (HibernateException e) {
            log.error("Find user by id error", e);
        }
        return userOptional;
    }

    @Override
    public List<User> findByLikeLogin(String key) {
        List<User> users = new ArrayList<>();
        try {
            users = crudRepository.query(
                    FROM_USER_WHERE_LOGIN_LIKE,
                    User.class, Map.of("key", MessageFormat.format("%{0}%", key)));
        } catch (HibernateException e) {
            log.error("Find by like login error", e);
        }
        return users;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User> userOptional = Optional.empty();
        try {
            userOptional = crudRepository.optional(
                    FROM_USER_WHERE_LOGIN_IS, User.class, Map.of("login", login));
        } catch (HibernateException e) {
            log.error("Find user by login error", e);
        }
        return userOptional;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        Optional<User> userOptional = Optional.empty();
        try {
            userOptional = crudRepository.optional(
                    FROM_USER_BY_LOGIN_AND_PASSWORD,
                    User.class, Map.of("login", login, "password", password));
        } catch (Exception e) {
            log.error("Find user by login and password error", e);
        }
        return userOptional;
    }
}