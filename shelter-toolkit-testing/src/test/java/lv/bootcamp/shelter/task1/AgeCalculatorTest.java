package lv.bootcamp.shelter.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Task 1: Pure logic tests
 *
 * Practice:
 * - Arrange-Act-Assert pattern
 * - Good test naming
 * - assertEquals for return values
 * - assertThrows for invalid input
 *
 * Instructions:
 * Write tests for AgeCalculator. Each TODO describes one test to write.
 * Remove the TODO comments as you implement each test.
 */
@DisplayName("AgeCalculator")
class AgeCalculatorTest {

    private AgeCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new AgeCalculator();
    }

    // --- toMonths() ---

    @Test
    @DisplayName("toMonths: 0 years returns 0 months")
    void shouldReturnZeroMonthsForZeroYears() {
        int years = 0;
        int months = calculator.toMonths(years);
        assertEquals(years, months);
    }

    @Test
    @DisplayName("toMonths: positive years returns correct months")
    void shouldConvertPositiveYearsToMonths() {
        int years = 3;
        int months = calculator.toMonths(years);
        assertEquals(3 * 12, months);
    }

    @Test
    @DisplayName("toMonths: negative years throws IllegalArgumentException")
    void shouldThrowForNegativeYears() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.toMonths(-1)
        );
        assertTrue(ex.getMessage().contains("negative"));
    }

    // --- dogToHumanYears() ---

    @Test
    @DisplayName("dogToHumanYears: age 0 returns 0")
    void shouldReturnZeroHumanYearsForPuppy() {
        int dogYears = 0;
        assertEquals(dogYears, calculator.dogToHumanYears(dogYears));
    }

    @Test
    @DisplayName("dogToHumanYears: age 1 returns 15")
    void shouldReturnFifteenForOneYearOldDog() {
        int dogYears = 1;
        assertEquals(15, calculator.dogToHumanYears(dogYears));
    }

    @Test
    @DisplayName("dogToHumanYears: age 2 returns 24")
    void shouldReturnTwentyFourForTwoYearOldDog() {
        int dogYears = 2;
        assertEquals(24, calculator.dogToHumanYears(dogYears));
    }

    @Test
    @DisplayName("dogToHumanYears: age 5 returns 39")
    void shouldCalculateCorrectlyForOlderDog() {
        int dogYears = 5;
        assertEquals(39, calculator.dogToHumanYears(dogYears));
    }

    @Test
    @DisplayName("dogToHumanYears: negative age throws IllegalArgumentException")
    void shouldThrowForNegativeDogAge() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calculator.dogToHumanYears(-1)
        );
    }

    // --- isBaby() ---

    @Test
    @DisplayName("isBaby: age 0 returns true")
    void shouldReturnTrueForAgeZero() {
        assertTrue(calculator.isBaby(0));
    }

    @Test
    @DisplayName("isBaby: age 1 returns false")
    void shouldReturnFalseForAgeOne() {
        assertFalse(calculator.isBaby(1));
    }
}
