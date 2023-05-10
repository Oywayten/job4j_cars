package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.User;
import ru.job4j.util.Util;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest {

    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();
    private static final CrudRepository CRUD_REPOSITORY = new CrudRepository(SESSION_FACTORY);
    private static final UserRepository USER_REPOSITORY = new UserRepository(CRUD_REPOSITORY);

    @AfterAll
    public static void getRegistryAndSessionFactory() {
        StandardServiceRegistryBuilder.destroy(REGISTRY);
    }

    @AfterEach
    public void deleteNewCreatedUsers() {
        Util.deleteNewCreatedUsers(CRUD_REPOSITORY);
    }

    @Test
    public void whenCreateUserThenUpdateIsNewPassword() {
        User user = new User();
        user.setLogin("user");
        user.setPassword("password");
        USER_REPOSITORY.create(user);
        user.setPassword("newPassword");
        USER_REPOSITORY.update(user);
        Optional<User> actualUserOptional = USER_REPOSITORY.findById(user.getId());
        User actualUser = actualUserOptional.orElse(null);
        String password = actualUser != null ? actualUser.getPassword() : null;
        assertThat(password).isEqualTo(user.getPassword());
    }

    @Test
    public void whenCreateNewUser1AndDeleteThenFindByIdIsNull() {
        User newUser = new User();
        newUser.setLogin("newUser1");
        newUser.setPassword("password1");
        USER_REPOSITORY.create(newUser);
        int newUserId = newUser.getId();
        USER_REPOSITORY.delete(newUserId);
        Optional<User> actualUserOptional = USER_REPOSITORY.findById(newUserId);
        User actualUser = actualUserOptional.orElse(null);
        assertThat(actualUser).isNull();
    }

    @Test
    public void whenFindAllOrderedByIdThenUser1User2User3() {
        User user1 = new User();
        user1.setLogin("Ivanov");
        String password = "root";
        user1.setPassword(password);
        User user2 = new User();
        user2.setLogin("Petrov");
        user2.setPassword(password);
        User user3 = new User();
        user3.setLogin("Sidorov");
        user3.setPassword(password);
        List<User> expectedUsers = List.of(user1, user2, user3);
        List<User> actualUsers = USER_REPOSITORY.findAllOrderedById();
        assertThat(actualUsers).isEqualTo(expectedUsers);
    }

    @Test
    public void whenCreateNewUserThenFindSameById() {
        User newUser = new User();
        newUser.setLogin("newUser");
        newUser.setPassword("password");
        USER_REPOSITORY.create(newUser);
        Optional<User> actualUserOptional = USER_REPOSITORY.findById(newUser.getId());
        User actualUser = actualUserOptional.orElse(null);
        assertThat(actualUser).isEqualTo(newUser);
    }

    @Test
    public void whenFindByLikeLoginIsPetrovAndSidirov() {
        User user1 = new User();
        user1.setLogin("Petrov");
        String password = "root";
        user1.setPassword(password);
        User user2 = new User();
        user2.setLogin("Sidorov");
        user2.setPassword(password);
        List<User> expectedUsers = List.of(user1, user2);
        List<User> actualUsers = USER_REPOSITORY.findByLikeLogin("rov");
        assertThat(actualUsers).isEqualTo(expectedUsers);
    }

    @Test
    public void whenFindByLoginIsPetrov() {
        User user1 = new User();
        String login = "Petrov";
        user1.setLogin(login);
        user1.setPassword("root");
        Optional<User> actualUserOptional = USER_REPOSITORY.findByLogin(login);
        User actualUser = actualUserOptional.orElse(null);
        String actualLogin = actualUser != null ? actualUser.getLogin() : null;
        assertThat(actualLogin).isEqualTo(login);
    }
}