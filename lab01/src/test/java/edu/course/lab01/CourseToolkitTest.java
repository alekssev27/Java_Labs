package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }
    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }
    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }
    @Test
    void returnsTrueForPrimeNumber() {
        boolean result = CourseToolkit.isPrime(13);

        assertTrue(result);
    }
    @Test
    void returnsFalseForCompositeNumber() {
        boolean result = CourseToolkit.isPrime(12);

        assertFalse(result);
    }
    @Test
    void returnsFalseForNumberLessThanTwo() {
        boolean result = CourseToolkit.isPrime(1);

        assertFalse(result);
    }
    @Test
    void returnsFalseForSquareOfPrime() {
        boolean result = CourseToolkit.isPrime(49);

        assertFalse(result);
    }
    @Test
    void returnsTrueForPalindrome() {
        boolean result = CourseToolkit.isPalindrome("radar");

        assertTrue(result);
    }
    @Test
    void returnsFalseForNonPalindrome() {
        boolean result = CourseToolkit.isPalindrome("hello");

        assertFalse(result);
    }
    @Test
    void treatsCaseAsSignificant() {
        boolean result = CourseToolkit.isPalindrome("Level");

        assertFalse(result);
    }
    @Test
    void throwsForNullText() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.isPalindrome(null)
        );
    }
    @Test
    void calculatesAverage() {
        int[] values = {10, 20, 30};

        double result = CourseToolkit.average(values);

        assertEquals(20.0, result);
    }

    @Test
    void calculatesNegativeAverage() {
        int[] values = {-10, -20, -30};

        double result = CourseToolkit.average(values);

        assertEquals(-20.0, result);
    }

    @Test
    void calculatesFractionalAverage() {
        int[] values = {1, 2};

        double result = CourseToolkit.average(values);

        assertEquals(1.5, result);
    }

    @Test
    void throwsForEmptyArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[0])
        );
    }

    @Test
    void throwsForNullArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(null)
        );
    }
    @Test
    void findsMinimumValue() {
        int[] values = {7, 3, 10, 2, 5};

        int result = CourseToolkit.min(values);

        assertEquals(2, result);
    }

    @Test
    void findsMaximumValue() {
        int[] values = {7, 3, 10, 2, 5};

        int result = CourseToolkit.max(values);

        assertEquals(10, result);
    }

    @Test
    void findsMinAndMaxWithNegativeValues() {
        int[] values = {-5, -10, 3, 8};

        assertEquals(-10, CourseToolkit.min(values));
        assertEquals(8, CourseToolkit.max(values));
    }

    @Test
    void throwsForEmptyArrayInMin() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.min(new int[0])
        );
    }

    @Test
    void throwsForEmptyArrayInMax() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.max(new int[0])
        );
    }
}
