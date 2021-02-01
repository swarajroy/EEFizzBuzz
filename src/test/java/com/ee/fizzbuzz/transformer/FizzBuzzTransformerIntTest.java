package com.ee.fizzbuzz.transformer;

import com.ee.fizzbuzz.converter.OperandConverter;
import com.ee.fizzbuzz.viewmodel.TransformationResult;
import com.ee.fizzbuzz.tranformer.FizzBuzzTransformer;
import com.ee.fizzbuzz.validator.RangeBoundValidator;
import org.junit.Before;
import org.junit.Test;

import static com.ee.fizzbuzz.Constants.MESSAGE;
import static com.ee.fizzbuzz.fixture.FizzBuzzFixture.EXPECTED_STRING_STEP_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class FizzBuzzTransformerIntTest {
    private FizzBuzzTransformer subjectUnderTest;

    @Before
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzTransformer(new OperandConverter(), new RangeBoundValidator());
    }

    @Test
    public void shouldExpectIllegalArgumentExceptionWhenIncorrectBoundArgumentsPassed() {
        assertThatIllegalArgumentException().isThrownBy(() -> this.subjectUnderTest.transform(0,0))
                .withMessageContaining(MESSAGE);
    }

    @Test
    public void shouldExpectTheTransformedStringAsPerExpectation() {
        final TransformationResult result = this.subjectUnderTest.transform(1, 20);
        assertThat(result.getTransformedOperandString()).isEqualTo(EXPECTED_STRING_STEP_1);
    }
}
