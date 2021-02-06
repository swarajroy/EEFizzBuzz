package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.SPACE_DELIMETER;
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

}