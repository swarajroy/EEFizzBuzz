package com.ee.fizzbuzz.converter;

import static com.ee.fizzbuzz.Constants.BUZZ;
import static com.ee.fizzbuzz.Constants.FIZZ;
import static com.ee.fizzbuzz.Constants.FIZZBUZZ;
import static org.assertj.core.api.Assertions.assertThat;

import com.ee.fizzbuzz.domain.TransformedOperand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OperandConverterTest {

  private OperandConverter subjectUnderTest;

  @BeforeEach
  public void setUp() {
    this.subjectUnderTest = new OperandConverter();
  }

  @Test
  public void shouldGetFizzBuzzIfNumberIsAMultipleOf3And5() {
    assertThat(this.subjectUnderTest.convert(15))
        .isEqualTo(TransformedOperand.create(FIZZBUZZ));
  }

  @Test
  public void shouldGetFizzIfNumberIsAMultipleOf3() {
    assertThat(this.subjectUnderTest.convert(6))
        .isEqualTo(TransformedOperand.create(FIZZ));
  }

  @Test
  public void shouldGetBuzzIfNumberIsAMultipleOf5() {
    assertThat(this.subjectUnderTest.convert(10))
        .isEqualTo(TransformedOperand.create(BUZZ));
  }

  @Test
  public void shoudGetNumberIfNumberIsNeitherAMultipleOf3Or5() {
    assertThat(this.subjectUnderTest.convert(7)).isEqualTo(TransformedOperand.create("7"));
  }
  
}