package com.ee.fizzbuzz.transformer;

import static com.ee.fizzbuzz.Constants.MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.ee.fizzbuzz.converter.OperandConverter;
import com.ee.fizzbuzz.domain.TransformedOperand;
import com.ee.fizzbuzz.tranformer.FizzBuzzTransformer;
import com.ee.fizzbuzz.validator.RangeBoundValidator;
import com.ee.fizzbuzz.viewmodel.TransformationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzTransformerTest {

    private FizzBuzzTransformer subjectUnderTest;

    @Mock
    private OperandConverter operandConverter;

    @Mock
    private RangeBoundValidator rangeBoundValidator;

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzTransformer(operandConverter, rangeBoundValidator);
    }

    @Test
    @DisplayName("Should expect IndexOutOfBoundsException when range bound validator is configured to return false and expect no invocations on operand converter")
    public void verifyNoInteractionsWithOperandConverter() {
        when(rangeBoundValidator.isValid(anyInt(), anyInt())).thenReturn(false);

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> this.subjectUnderTest.transform(-1,-1))
                .withMessageContaining(MESSAGE);

        verify(rangeBoundValidator, times(1)).isValid(anyInt(), anyInt());
        verifyNoInteractions(operandConverter);
    }

    @Test
    @DisplayName("Should expect result to be non null and verify calls to operand converter when range bound validator is configured to return true")
    public void expectCallsToOperandConverter() {
        when(rangeBoundValidator.isValid(anyInt(), anyInt())).thenReturn(true);
        when(operandConverter.convert(anyInt())).thenReturn(TransformedOperand.create("1")).thenReturn(TransformedOperand.create("2"));

        final TransformationResult result = this.subjectUnderTest.transform(1, 2);

        assertThat(result).isNotNull();
        verify(rangeBoundValidator, times(1)).isValid(anyInt(), anyInt());
        verify(operandConverter, times(2)).convert(anyInt());
    }
}