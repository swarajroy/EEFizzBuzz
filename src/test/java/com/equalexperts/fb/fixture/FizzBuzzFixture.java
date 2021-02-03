package com.equalexperts.fb.fixture;

import com.equalexperts.fb.Constants;
import com.equalexperts.fb.domain.TransformedOperand;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class FizzBuzzFixture {
    public static final String EXPECTED_STRING_STEP_1 = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
    public static final TransformedOperand FIZZ = TransformedOperand.create(Constants.FIZZ);
    public static final TransformedOperand BUZZ = TransformedOperand.create(Constants.BUZZ);
    public static final TransformedOperand FIZZBUZZ = TransformedOperand.create(Constants.FIZZBUZZ);

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
            Arguments.of(1, TransformedOperand.create("1")),
            Arguments.of(2, TransformedOperand.create("2")),
            Arguments.of(4, TransformedOperand.create("4")),
            Arguments.of(7, TransformedOperand.create("7")),
            Arguments.of(8, TransformedOperand.create("8"))
        );
    }
}
