package com.equalexperts.fb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TransformedResultTest {

  public static final String EXPECTED = "1 2";

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

}