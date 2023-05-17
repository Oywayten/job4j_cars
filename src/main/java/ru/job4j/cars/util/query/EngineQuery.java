package ru.job4j.cars.util.query;

/**
 * Oywayten 17.05.2023.
 */
public class EngineQuery {
    private static final String FROM_ENGINE = "FROM Engine AS e";
    private static final String ORDER_BY_NAME_ASC = "ORDER BY e.name ASC";
    public static final String FROM_ENGINE_ORDER_BY_NAME_ASC = String.format("%s %s", FROM_ENGINE, ORDER_BY_NAME_ASC);
    private static final String WHERE_ID_IS = "WHERE id = :engineId";
    public static final String FROM_ENGINE_WHERE_ID_IS = String.format("%s %s", FROM_ENGINE, WHERE_ID_IS);
}
