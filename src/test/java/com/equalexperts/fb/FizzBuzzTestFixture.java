package com.equalexperts.fb;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class FizzBuzzTestFixture {

    private static final String FIZZBUZZ = "fizzbuzz";
    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    public static Stream<Arguments> multiplesOf3() {
        return Stream.of(
            Arguments.of(3, FIZZ),
            Arguments.of(6, FIZZ),
            Arguments.of(9, FIZZ),
            Arguments.of(12, FIZZ),
            Arguments.of(18, FIZZ)
        );
    }

    public static Stream<Arguments> multiplesOf5() {
        return Stream.of(
            Arguments.of(5, BUZZ),
            Arguments.of(10, BUZZ),
            Arguments.of(20, BUZZ),
            Arguments.of(25, BUZZ),
            Arguments.of(35, BUZZ)
        );
    }

    public static Stream<Arguments> multiplesOf15() {
        return Stream.of(
            Arguments.of(15, FIZZBUZZ),
            Arguments.of(30, FIZZBUZZ),
            Arguments.of(45, FIZZBUZZ),
            Arguments.of(60, FIZZBUZZ),
            Arguments.of(75, FIZZBUZZ)
        );
    }

    public static Stream<Arguments> numbers() {
        return Stream.of(
            Arguments.of(1, "1"),
            Arguments.of(2, "2"),
            Arguments.of(4, "4"),
            Arguments.of(7, "7"),
            Arguments.of(8, "8")
        );
    }

    public static Stream<Arguments> compoundInput() {
        return Stream.of(
            Arguments.of(3, FIZZ),
            Arguments.of(30, FIZZBUZZ),
            Arguments.of(5, BUZZ),
            Arguments.of(15, FIZZBUZZ),
            Arguments.of(50, BUZZ),
            Arguments.of(7, "7")
        );
    }
}
