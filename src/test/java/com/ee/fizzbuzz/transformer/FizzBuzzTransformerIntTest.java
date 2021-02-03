package com.ee.fizzbuzz.transformer;

import static com.ee.fizzbuzz.Constants.MESSAGE;
import static com.ee.fizzbuzz.fixture.FizzBuzzFixture.EXPECTED_STRING_STEP_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.ee.fizzbuzz.converter.OperandConverter;
import com.ee.fizzbuzz.tranformer.FizzBuzzTransformer;
import com.ee.fizzbuzz.validator.RangeBoundValidator;
import com.ee.fizzbuzz.viewmodel.TransformationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzTransformerIntTest {

    private FizzBuzzTransformer subjectUnderTest;

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzTransformer(new OperandConverter(), new RangeBoundValidator());
    }

    @Test
    @DisplayName("Should expect IllegalArgumentException when incorrect bound arguments passed")
    public void expectIndexOutOfBounds() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> this.subjectUnderTest.transform(0,0))
                .withMessageContaining(MESSAGE);
    }

    @Test
    @DisplayName("Should expect the transformed string as per expectation")
    public void expectTransformedString() {
        final TransformationResult result = this.subjectUnderTest.transform(1, 20);
        assertThat(result.getTransformedOperandString()).isEqualTo(EXPECTED_STRING_STEP_1);
    }
}
