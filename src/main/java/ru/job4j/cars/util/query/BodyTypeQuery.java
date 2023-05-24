package ru.job4j.cars.util.query;

/**
 * Oywayten 17.05.2023.
 */
public class BodyTypeQuery {

    private static final String FROM_BODY = "FROM BodyType AS b";
    private static final String ORDER_BY_NAME_ASC = "ORDER BY b.name ASC";
    public static final String FROM_BODY_ORDER_BY_NAME_ASC =
            String.format("%s %s", FROM_BODY, ORDER_BY_NAME_ASC);
    private static final String WHERE_ID_IS = "WHERE id = :bodyTypeId";
    public static final String FROM_BODY_TYPE_WHERE_ID_IS =
            String.format("%s %s", FROM_BODY, WHERE_ID_IS);
}
