package com.equalexperts.fb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzGeneratorTest {

    private FizzBuzzGenerator subjectUnderTest;

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzGenerator(new OperandConverter(new NumberUtils()));
    }

    @Test
    @DisplayName("Should do the fizz buzz transformation build report and print result")
    public void expectTransformedStringWithLucky_Fizz_Buzz_FizzBuzzAndNumbers_And_ReportMetrics() {

        final TransformedResult result = this.subjectUnderTest.transform(1, 20).buildReport();

        assertThat(result).isNotNull();

        System.out.println(result.getValue());

    }
}
