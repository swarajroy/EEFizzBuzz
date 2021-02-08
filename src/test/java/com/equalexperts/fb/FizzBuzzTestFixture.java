package com.equalexperts.fb;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class FizzBuzzTestFixture {

    public static final String FIZZBUZZ = "fizzbuzz";
    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";
    public static final String LUCKY = "lucky";

    public static Stream<Arguments> multiplesOf3() {
        return Stream.of(
            Arguments.of(3, true),
            Arguments.of(6, true),
            Arguments.of(9, true),
            Arguments.of(12, true),
            Arguments.of(18, true),

            Arguments.of(2, false),
            Arguments.of(20, false),
            Arguments.of(35, false),
            Arguments.of(43, false),
            Arguments.of(41, false)
        );
    }


    public static Stream<Arguments> multiplesOf5() {
        return Stream.of(
            Arguments.of(5, true),
            Arguments.of(10, true),
            Arguments.of(20, true),
            Arguments.of(25, true),
            Arguments.of(35, true),

            Arguments.of(2, false),
            Arguments.of(21, false),
            Arguments.of(37, false),
            Arguments.of(43, false),
            Arguments.of(41, false)
        );
    }


    public static Stream<Arguments> multiplesOf15() {
        return Stream.of(
            Arguments.of(15, true),
            Arguments.of(30, true),
            Arguments.of(45, true),
            Arguments.of(60, true),
            Arguments.of(75, true),

            Arguments.of(32, false),
            Arguments.of(21, false),
            Arguments.of(43, false),
            Arguments.of(42, false),
            Arguments.of(53, false)
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

    public static Stream<Arguments> contains3() {
        return Stream.of(
            Arguments.of(3, true),
            Arguments.of(11, false),
            Arguments.of(13, true),
            Arguments.of(22, false),
            Arguments.of(23, true),
            Arguments.of(29, false),
            Arguments.of(30, true),
            Arguments.of(33, true)
        );
    }

    public static Stream<Arguments> compoundInput() {
        return Stream.of(
            Arguments.of(3, LUCKY),
            Arguments.of(30, LUCKY),
            Arguments.of(5, BUZZ),
            Arguments.of(15, FIZZBUZZ),
            Arguments.of(50, BUZZ),
            Arguments.of(7, "7")
        );
    }

    public static Stream<Arguments> isNumeric() {
        return Stream.of(
            Arguments.of(null, false),
            Arguments.of("", false),
            Arguments.of("1", true),
            Arguments.of("2", true),
            Arguments.of("4", true),
            Arguments.of("lucky", false),
            Arguments.of("23", true)
        );
    }


}
