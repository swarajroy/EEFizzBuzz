package com.equalexperts.fb;

import static com.equalexperts.fb.FizzBuzzFixture.EXPECTED_STRING_STEP_1;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzTransformerIntTest {

    private FizzBuzzTransformer subjectUnderTest;

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzTransformer(new OperandConverter());
    }

    @Test
    @DisplayName("Should expect the transformed string as per expectation")
    public void expectTransformedString() {
        final TransformationResult result = this.subjectUnderTest.transform(1, 20);
        assertThat(result.getTransformedOperandString()).isEqualTo(EXPECTED_STRING_STEP_1);
    }
}
