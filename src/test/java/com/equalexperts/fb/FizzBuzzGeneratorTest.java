package com.equalexperts.fb;

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
    @DisplayName("Should do the fizz buzz transformation and print result")
    public void expectTransformedStringWithFizz_Buzz_FizzBuzzAndNumbers() {
        final String result = this.subjectUnderTest.transform(1, 20);
        System.out.println(result);
    }
}
