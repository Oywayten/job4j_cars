package ru.job4j.cars.util.query;

/**
 * Oywayten 17.05.2023.
 */
public class CategoryQuery {

    private static final String FROM_CATEGORY = "FROM Category AS g";
    private static final String ORDER_BY_NAME_ASC = "ORDER BY g.name ASC";
    public static final String FROM_CATEGORY_ORDER_BY_NAME_ASC = String.format("%s %s", FROM_CATEGORY, ORDER_BY_NAME_ASC);
    private static final  String WHERE_ID_IS = "WHERE id = :categoryId";
    public static final String FROM_CATEGORY_WHERE_ID_IS = String.format("%s %s", FROM_CATEGORY, WHERE_ID_IS);
}
