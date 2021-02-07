package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.SPACE_DELIMETER;
import static com.equalexperts.fb.FizzBuzzTestFixture.EXPECTED;
import static com.equalexperts.fb.FizzBuzzTestFixture.EXPECTED_VALUE;
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
    assertThat(result.getValue()).isEqualTo(EXPECTED);
    assertThat(result.getValue()).doesNotStartWith(SPACE_DELIMETER);
    assertThat(result.getValue()).doesNotEndWith(SPACE_DELIMETER);
  }

  @Test
  public void expectValueWithTransformationIntoFizz_Buzz_FizzBuzz_Lucky_Integer_And_Report_Of_Counts() {
    final TransformedResult input = TRANSFORMED_RESULT;

    final String valueAndMetrics = input.getValueAndMetrics();

    assertThat(valueAndMetrics).isNotBlank();
    assertThat(valueAndMetrics).isEqualTo(EXPECTED_VALUE);
    assertThat(valueAndMetrics).doesNotStartWith(SPACE_DELIMETER);
    assertThat(valueAndMetrics).doesNotEndWith(SPACE_DELIMETER);
  }

}