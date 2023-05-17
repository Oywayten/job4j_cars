package ru.job4j.cars.util.query;

/**
 * Oywayten 17.05.2023.
 */
public class PostQuery {

    public static final String UPDATE_POST_SET_SOLD_TRUE_WHERE_POST_ID_AND_USER_ID_IS =
            "UPDATE Post AS p SET p.sold = true WHERE p.id = :postId AND p.user.id = :userId";
    private static final String FROM_POST = "FROM Post AS p";
    private static final String WHERE_CAR_MODEL_BRAND_IS = "WHERE p.car.carModel.brand.name = :brand";
    public static final String FROM_POST_WHERE_CAR_MODEL_BRAND_IS = String.format("%s %s", FROM_POST, WHERE_CAR_MODEL_BRAND_IS);
    private static final String WHERE_ID_IS = "WHERE id = :id";
    public static final String FROM_POST_WHERE_ID_IS = String.format("%s %s", FROM_POST, WHERE_ID_IS);
    private static final String ORDER_BY_CREATED_ASC = "ORDER BY p.created ASC";
    public static final String FROM_POST_ORDER_BY_CREATED_ASC = String.format("%s %s", FROM_POST, ORDER_BY_CREATED_ASC);
    private static final String WHERE_CREATED_MORE_THAN_DATE = "WHERE p.created >= :date";
    public static final String FROM_POST_WHERE_CREATED_MORE_THAN_DATE_ORDER_BY_CREATED_ASC =
            String.format("%s %s %s", FROM_POST, WHERE_CREATED_MORE_THAN_DATE, ORDER_BY_CREATED_ASC);
    private static final String WHERE_PHOTO_IS_NOT_NULL = "WHERE p.photo IS NOT NULL";
    public static final String FROM_POST_WHERE_PHOTO_IS_NOT_NULL_ORDER_BY_CREATED_ASC =
            String.format("%s %s %s", FROM_POST, WHERE_PHOTO_IS_NOT_NULL, ORDER_BY_CREATED_ASC);
}
