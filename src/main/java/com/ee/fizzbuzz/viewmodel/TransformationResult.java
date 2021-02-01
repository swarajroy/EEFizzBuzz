package com.ee.fizzbuzz.viewmodel;

import com.ee.fizzbuzz.domain.TransformedOperand;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.ee.fizzbuzz.Constants.SPACE_DELIMETER;

public final class TransformationResult {
  private final List<TransformedOperand> transformedOperands;
  private final String transformedOperandString;

  private TransformationResult(final List<TransformedOperand> transformedOperands) {
    this.transformedOperands = transformedOperands;
    this.transformedOperandString = String.join(SPACE_DELIMETER, getTransformedStringOperands()).trim();
  }

  public static TransformationResult create(final List<TransformedOperand> transformedOperands) {
    return new TransformationResult(transformedOperands);
  }

  private List<String> getTransformedStringOperands() {
    return !this.transformedOperands.isEmpty() ? this.transformedOperands.stream().map(TransformedOperand::getValue).collect(Collectors.toList()) : Collections.emptyList();
  }

  public String getTransformedOperandString() {
    return transformedOperandString;
  }

  @Override
  public String toString() {
    return "TransformationResult{" +
            "transformedOperands=" + transformedOperands +
            ", transformedOperandString='" + transformedOperandString + '\'' +
            '}';
  }
}
