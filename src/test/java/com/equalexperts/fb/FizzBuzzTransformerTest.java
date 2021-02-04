package com.equalexperts.fb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzTransformer(operandConverter);
    }

    @Test
    @DisplayName("Should expect result to be non null and verify calls to operand converter")
    public void expectCallsToOperandConverter() {
        when(operandConverter.convert(anyInt())).thenReturn("1").thenReturn("2");

        final TransformationResult result = this.subjectUnderTest.transform(1, 2);

        assertThat(result).isNotNull();
        verify(operandConverter, times(2)).convert(anyInt());
    }
}