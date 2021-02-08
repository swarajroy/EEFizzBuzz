package com.equalexperts.fb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzGeneratorTest {

    private static final String EXPECTED = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
    private FizzBuzzGenerator subjectUnderTest;

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzGenerator(new OperandConverter());
    }

    @Test
    @DisplayName("Should do the fizz buzz transformation, check result not null, value is not blank and is equal to expected")
    public void expectTransformedStringWithFizz_Buzz_FizzBuzzAndNumbers() {
        final TransformedResult result = this.subjectUnderTest.transform(1, 20);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isNotBlank();
        assertThat(result.getValue()).isEqualTo(EXPECTED);
    }
}
