package com.equalexperts.fb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TransformedResultTest {

  private static final String EXPECTED = "1 2";
  private static final String EXPECTED_VALUE = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10";
  private static final TransformedResult TRANSFORMED_RESULT = TransformedResult.create(List.of(
      "1",
      "2",
      "lucky",
      "4",
      "buzz",
      "fizz",
      "7",
      "8",
      "fizz",
      "buzz",

      "11",
      "fizz",
      "lucky",
      "14",
      "fizzbuzz",
      "16",
      "17",
      "fizz",
      "19",
      "buzz"
  ));

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
    assertThat(result.getValue()).isNotBlank();
    assertThat(result.getValue()).isEqualTo(EXPECTED);
  }

  @Test
  public void expectValueWithTransformationIntoFizz_Buzz_FizzBuzz_Lucky_Integer_And_Report_Of_Counts() {

    final String valueAndMetrics = TRANSFORMED_RESULT.getValueAndMetrics();

    assertThat(valueAndMetrics).isNotBlank();
    assertThat(valueAndMetrics).isEqualTo(EXPECTED_VALUE);
  }

}