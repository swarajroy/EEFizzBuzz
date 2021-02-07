package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.SPACE_DELIMETER;
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
public class FizzBuzzGeneratorUnitTest {

    public static final String EXPECTED = "1 2";
    private FizzBuzzGenerator subjectUnderTest;

    @Mock
    private OperandConverter operandConverter;

    @BeforeEach
    public void setUp() {
        this.subjectUnderTest = new FizzBuzzGenerator(operandConverter);
    }

    @Test
    @DisplayName("Should expect result to be present and verify calls to operand converter")
    public void expectANonEmptyResultAndVerifyCallsToOperandConverter() {
        when(operandConverter.convert(anyInt())).thenReturn("1").thenReturn("2");

        final TransformedResult result = this.subjectUnderTest.transform(1, 2);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isNotBlank();
        assertThat(result.getValue()).isEqualTo(EXPECTED);

        verify(operandConverter, times(2)).convert(anyInt());
    }
}