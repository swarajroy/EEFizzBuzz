package com.equalexperts.fb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class OperandConverterTest {

  private OperandConverter subjectUnderTest;

  @BeforeEach
  public void setUp() {
    this.subjectUnderTest = new OperandConverter(new NumberUtils());
  }

  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#compoundInput")
  public void compound(final int input, final String result) {
    assertThat(this.subjectUnderTest.convert(input)).isEqualTo(result);
  }
}
