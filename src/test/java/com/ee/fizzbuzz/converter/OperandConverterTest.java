package com.ee.fizzbuzz.converter;

import com.ee.fizzbuzz.domain.TransformedOperand;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class OperandConverterTest {
  private OperandConverter subjectUnderTest;

  @Before
  public void setUp() {
    this.subjectUnderTest = new OperandConverter();
  }

  @Test
  public void shouldGetFizzBuzzIfNumberIsAMultipleOf3And5() {
    Assertions.assertThat(this.subjectUnderTest.convert(15)).isEqualTo(TransformedOperand.create("fizzbuzz"));
  }

  @Test
  public void shouldGetFizzIfNumberIsAMultipleOf3() {
    Assertions.assertThat(this.subjectUnderTest.convert(6)).isEqualTo(TransformedOperand.create("fizz"));
  }

  @Test
  public void shouldGetBuzzIfNumberIsAMultipleOf5() {
    Assertions.assertThat(this.subjectUnderTest.convert(10)).isEqualTo(TransformedOperand.create("buzz"));
  }

  @Test
  public void shoudGetNumberIfNumberIsNeitherAMultipleOf3Or5() {
    Assertions.assertThat(this.subjectUnderTest.convert(7)).isEqualTo(TransformedOperand.create("7"));
  }
  
}