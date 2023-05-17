package ru.job4j.cars.util.query;

/**
 * Oywayten 17.05.2023.
 */
public class UserQuery {
    private static final String DELETE = "DELETE";
    private static final String FROM_USER = "FROM User AS u";
    private static final String WHERE_ID_IS = "WHERE id = :id";
    public static final String FROM_USER_WHERE_ID_IS = String.format("%s %s", FROM_USER, WHERE_ID_IS);
    public static final String DELETE_BY_ID = String.format("%s %s", DELETE, FROM_USER_WHERE_ID_IS);
    private static final String ORDER_BY_ID_ASC = "ORDER BY u.id ASC";
    public static final String FROM_USER_ORDER_BY_ID_ASC = String.format("%s %s", FROM_USER, ORDER_BY_ID_ASC);
    private static final String WHERE_LOGIN_LIKE = "WHERE u.login LIKE :key";
    public static final String FROM_USER_WHERE_LOGIN_LIKE = String.format("%s %s", FROM_USER, WHERE_LOGIN_LIKE);
    private static final String WHERE_LOGIN_IS = "WHERE u.login = :login";
    public static final String FROM_USER_WHERE_LOGIN_IS = String.format("%s %s", FROM_USER, WHERE_LOGIN_IS);
    private static final String WHERE_LOGIN_AND_PASSWORD_IS = "WHERE login = :login AND password = :password";
    public static final String FROM_USER_BY_LOGIN_AND_PASSWORD = String.format("%s %s", FROM_USER, WHERE_LOGIN_AND_PASSWORD_IS);
}
