package com.equalexperts.fb.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RangeBoundValidatorTest {

    private RangeBoundValidator subjectUnderTest;

    private static Stream<Arguments> testCreateArgs() {
        return Stream.of(
            Arguments.of(0, 0, false),
            Arguments.of(-1, 0, false),
            Arguments.of(0, -1, false),
            Arguments.of(-1, -1, false),
            Arguments.of(0, 1, false),
            Arguments.of(1, 0, false),
            Arguments.of(1, -1, false),
            Arguments.of(-1, 1, false),
            Arguments.of(20, 1, false),

            Arguments.of(1, 20, true)
        );
    }

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new RangeBoundValidator();
    }

    @ParameterizedTest
    @MethodSource("testCreateArgs")
    public void test(int start, int endInclusive, boolean result) {
        assertThat(this.subjectUnderTest.isValid(start, endInclusive)).isEqualTo(result);
    }

}