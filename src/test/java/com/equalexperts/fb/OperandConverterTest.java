package com.equalexperts.fb;

import static org.assertj.core.api.Assertions.assertThat;

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
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#multiplesOf15")
  public void multiplesOf15(final int input, final String result) {
    assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#multiplesOf5")
  public void multiplesOf5(final int input, final String result) {
    assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#multiplesOf3")
  public void multiplesOf3(final int input, final String result) {
    assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#numbers")
  public void numbers(final int input, final String result) {
    assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#compoundInput")
  public void compound(final int input, final String result) {
    assertThat(this.subjectUnderTest.convert(input))
        .isEqualTo(result);
  }
  
}