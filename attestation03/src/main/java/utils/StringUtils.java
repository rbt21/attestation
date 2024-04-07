package utils;

public class StringUtils {

    private StringUtils() {
        // Закрытый конструктор для предотвращения создания экземпляра утилитного класса
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}

