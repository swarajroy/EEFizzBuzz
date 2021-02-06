package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.SPACE_DELIMETER;
import static com.equalexperts.fb.FizzBuzzTestFixture.TRANSFORMED_RESULT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TransformedResultTest {

  @Test
  public void expectEmptyStringWhenValuesNull() {
    final TransformedResult result = TransformedResult.create(null);
    assertThat(result).isNotNull();
    assertThat(result.getValue()).isBlank();
  }

  @Test
  public void expectEmptyStringWhenValuesEmpty() {
    final TransformedResult result = TransformedResult.create(List.of());
    assertThat(result).isNotNull();
    assertThat(result.getValue()).isBlank();
  }

  @Test
  public void expectStringValuesWithSpacesWhenValuesPresent() {
    final TransformedResult result = TransformedResult.create(List.of("1", "2"));
    assertThat(result).isNotNull();
    assertThat(result.getValue()).isEqualTo("1 2");
    assertThat(result.getValue()).doesNotStartWith(SPACE_DELIMETER);
    assertThat(result.getValue()).doesNotEndWith(SPACE_DELIMETER);
  }

  @Test
  public void expectValueWithTransformationIntoFizzBuzzesLucky_And_Report_Of_Count() {
    final TransformedResult result = TRANSFORMED_RESULT;
    final String EXPECTED_VALUE = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10";

    result.buildReport();

    assertThat(result).isNotNull();
    assertThat(result.getValue()).isNotBlank();
    assertThat(result.getValue()).isEqualTo(EXPECTED_VALUE);
    assertThat(result.getValue()).doesNotStartWith(SPACE_DELIMETER);
    assertThat(result.getValue()).doesNotEndWith(SPACE_DELIMETER);
  }

}