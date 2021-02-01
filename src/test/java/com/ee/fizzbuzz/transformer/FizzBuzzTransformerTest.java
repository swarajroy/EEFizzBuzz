package com.ee.fizzbuzz.transformer;

import com.ee.fizzbuzz.converter.OperandConverter;
import com.ee.fizzbuzz.viewmodel.TransformationResult;
import com.ee.fizzbuzz.domain.TransformedOperand;
import com.ee.fizzbuzz.tranformer.FizzBuzzTransformer;
import com.ee.fizzbuzz.validator.RangeBoundValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.ee.fizzbuzz.Constants.MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTransformerTest {

    private FizzBuzzTransformer subjectUnderTest;

    @Mock
    private OperandConverter operandConverter;

    @Mock
    private RangeBoundValidator rangeBoundValidator;

    @Before
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzTransformer(operandConverter, rangeBoundValidator);
    }

    @Test
    public void shouldExpectIllegalArgumentExceptionWhenRangeBoundValidatorIsConfiguredToReturnFalseAndExpectNoInvocationsToOperandConverter() {
        when(rangeBoundValidator.isValid(anyInt(), anyInt())).thenReturn(false);

        assertThatIllegalArgumentException().isThrownBy(() -> this.subjectUnderTest.transform(-1,-1))
                .withMessageContaining(MESSAGE);

        verify(rangeBoundValidator, times(1)).isValid(anyInt(), anyInt());
        verifyNoInteractions(operandConverter);
    }

    @Test
    public void shouldExpectCallsToOperandConverterWhenRangeBoundValidatorIsConfiguredToReturnTrue() {
        when(rangeBoundValidator.isValid(anyInt(), anyInt())).thenReturn(true);
        when(operandConverter.convert(anyInt())).thenReturn(TransformedOperand.create("1")).thenReturn(TransformedOperand.create("2"));

        final TransformationResult result = this.subjectUnderTest.transform(1, 2);

        assertThat(result).isNotNull();
        assertThat(result.getTransformedOperandString()).isEqualTo("1 2");

        verify(rangeBoundValidator, times(1)).isValid(anyInt(), anyInt());
        verify(operandConverter, times(2)).convert(anyInt());

    }
}