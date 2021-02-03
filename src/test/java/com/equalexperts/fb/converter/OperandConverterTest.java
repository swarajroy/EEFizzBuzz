package com.equalexperts.fb.converter;

import static org.assertj.core.api.Assertions.assertThat;

import com.equalexperts.fb.domain.TransformedOperand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class OperandConverterTest {

  private OperandConverter subjectUnderTest;


  @BeforeEach
  public void setUp() {
    this.subjectUnderTest = new OperandConverter();
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.fixture.FizzBuzzFixture#multiplesOf15")
  public void multiplesOf15(final int input, final TransformedOperand result) {
    Assertions.assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.fixture.FizzBuzzFixture#multiplesOf5")
  public void multiplesOf5(final int input, final TransformedOperand result) {
    Assertions.assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.fixture.FizzBuzzFixture#multiplesOf3")
  public void multiplesOf3(final int input, final TransformedOperand result) {
    Assertions.assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.fixture.FizzBuzzFixture#numbers")
  public void numbers(final int input, final TransformedOperand result) {
    Assertions.assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }

  
}