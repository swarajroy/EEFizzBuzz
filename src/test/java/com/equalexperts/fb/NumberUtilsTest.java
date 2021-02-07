package com.equalexperts.fb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class NumberUtilsTest {

  private NumberUtils subjectUnderTest;

  @BeforeEach
  public void setUp() {
    this.subjectUnderTest = new NumberUtils();
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#contains3")
  public void contains3(final int number, final boolean result) {
    assertThat(this.subjectUnderTest.contains3(number)).isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#multiplesOf15")
  public void multiplesOf15(final int input, final boolean result) {
    assertThat(this.subjectUnderTest.multipleOf15(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#multiplesOf5")
  public void multiplesOf5(final int input, final boolean result) {
    assertThat(this.subjectUnderTest.multipleOf5(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#multiplesOf3")
  public void multiplesOf3(final int input, final boolean result) {
    assertThat(this.subjectUnderTest.multipleOf3(input)).isEqualTo(result);
  }

}
