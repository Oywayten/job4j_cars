package ru.job4j.util;

import ru.job4j.cars.repository.CrudRepository;

import java.util.Map;

public class Util {
    private static final int BASE_USERS_COUNT = 3;

    public static void deleteNewCreatedUsers(CrudRepository crudRepository) {
        crudRepository.run("DELETE FROM User WHERE id > :count", Map.of("count", BASE_USERS_COUNT));
    }

}
