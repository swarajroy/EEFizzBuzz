package com.equalexperts.fb;

import static com.equalexperts.fb.FizzBuzzTestFixture.EXPECTED;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzGeneratorTest {

    private FizzBuzzGenerator subjectUnderTest;

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzGenerator(new OperandConverter());
    }

    @Test
    @DisplayName("Should expect the result as per expectation")
    public void expectTransformedStringWithFizz_Buzz_FizzBuzzAndNumbers() {
        final String result = this.subjectUnderTest.transform(1, 20);

        System.out.println(result);
        assertThat(result).isEqualTo(EXPECTED);
    }
}
