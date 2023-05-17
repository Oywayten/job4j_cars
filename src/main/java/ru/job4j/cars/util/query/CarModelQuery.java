package ru.job4j.cars.util.query;

/**
 * Oywayten 17.05.2023.
 */
public class CarModelQuery {

    private static final String FROM_CAR_MODEL = "FROM CarModel AS m";
    private static final String JOIN_FETCH_BRAND = "JOIN FETCH m.brand as b";
    private static final String ORDER_BY_CAR_MODEL_ASC_BRAND_ASC = "ORDER BY b.name ASC, m.name ASC";
    public static final String FROM_CAR_MODEL_JOIN_FETCH_BRAND_ORDER_BY_CAR_MODEL_ASC_BRAND_ASC =
            String.format("%s %s %s", FROM_CAR_MODEL, JOIN_FETCH_BRAND, ORDER_BY_CAR_MODEL_ASC_BRAND_ASC);
    private static final String WHERE_ID_IS = "WHERE id = :carModelId";
    public static final String FROM_CAR_MODEL_WHERE_ID_IS = String.format("%s %s", FROM_CAR_MODEL, WHERE_ID_IS);
}
