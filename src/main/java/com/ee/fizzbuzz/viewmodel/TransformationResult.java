package com.ee.fizzbuzz.viewmodel;

import static com.ee.fizzbuzz.Constants.SPACE_DELIMETER;
import static java.util.stream.Collectors.toList;

import com.ee.fizzbuzz.domain.TransformedOperand;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public final class TransformationResult {
  private final Collection<TransformedOperand> transformedOperands;

  private TransformationResult(final Collection<TransformedOperand> transformedOperands) {
    this.transformedOperands = transformedOperands;
  }

  public static TransformationResult create(final Collection<TransformedOperand> transformedOperands) {
    return new TransformationResult(transformedOperands);
  }

  private Collection<String> getTransformedStringOperands() {
    return Objects.nonNull(this.transformedOperands) && !this.transformedOperands.isEmpty() ?
        this.transformedOperands.stream().map(TransformedOperand::getValue).collect(
        toList()): Collections.emptyList();
  }

  public String getTransformedOperandString() {
    return String.join(SPACE_DELIMETER, getTransformedStringOperands()).trim();
  }

  @Override
  public String toString() {
    return "TransformationResult{" +
        "transformedOperands=" + transformedOperands +
        '}';
  }
}
