package utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilsTest {

    @Test
    void testAddDaysToDate() {
        LocalDate initialDate = LocalDate.of(2022, 4, 30);
        LocalDate expectedDate = LocalDate.of(2022, 5, 5); // Добавляем 5 дней
        LocalDate actualDate = DateUtils.addDaysToDate(initialDate, 5);
        assertEquals(expectedDate, actualDate);
    }
}
