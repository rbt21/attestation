package utils;

import org.junit.jupiter.api.Test;
import utils.StringUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {

    @Test
    void testIsNullOrEmptyWhenNull() {
        assertTrue(StringUtils.isNullOrEmpty(null));
    }

    @Test
    void testIsNullOrEmptyWhenEmpty() {
        assertTrue(StringUtils.isNullOrEmpty(""));
    }

    @Test
    void testIsNullOrEmptyWhenBlank() {
        assertTrue(StringUtils.isNullOrEmpty(" "));
    }

    @Test
    void testIsNullOrEmptyWhenText() {
        assertFalse(StringUtils.isNullOrEmpty("text"));
    }
}
