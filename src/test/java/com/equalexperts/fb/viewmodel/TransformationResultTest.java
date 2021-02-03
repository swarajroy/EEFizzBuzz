package com.equalexperts.fb.viewmodel;


import static com.equalexperts.fb.Constants.SPACE_DELIMETER;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

import com.equalexperts.fb.domain.TransformedOperand;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TransformationResultTest {

  @Test
  @DisplayName("Expect the result string to be empty when null input passed")
  public void expectEmptyStringWhenNullPassed() {
    assertThat(TransformationResult.create(null).getTransformedOperandString()).isBlank();
  }

  @Test
  @DisplayName("Expect the result string to be empty when empty input passed")
  public void expectEmptyStringWhenWhenEmptyPassed() {
    assertThat(TransformationResult.create(emptyList()).getTransformedOperandString()).isBlank();
  }

  @Test
  @DisplayName("verify the result string to be equal to 1 2 with no leading or trailing spaces")
  public void expectResultStringWhenCollectionEmptyWhenNullPassed() {
    final String result = TransformationResult.create(List.of(
        TransformedOperand.create("1"),
        TransformedOperand.create("2")
        )).getTransformedOperandString();

    assertThat(result).isEqualTo("1 2");
    assertThat(result).doesNotStartWith(SPACE_DELIMETER);
    assertThat(result).doesNotEndWith(SPACE_DELIMETER);
  }
}