package com.equalexperts.fb;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class FizzBuzzTestFixture {

    public static Stream<Arguments> multiplesOf3() {
        return Stream.of(
            Arguments.of(3, true),
            Arguments.of(6, true),
            Arguments.of(9, true),
            Arguments.of(12, true),
            Arguments.of(18, true)
        );
    }


    public static Stream<Arguments> multiplesOf5() {
        return Stream.of(
            Arguments.of(5, true),
            Arguments.of(10, true),
            Arguments.of(20, true),
            Arguments.of(25, true),
            Arguments.of(35, true)
        );
    }


    public static Stream<Arguments> multiplesOf15() {
        return Stream.of(
            Arguments.of(15, true),
            Arguments.of(30, true),
            Arguments.of(45, true),
            Arguments.of(60, true),
            Arguments.of(75, true)
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
}
