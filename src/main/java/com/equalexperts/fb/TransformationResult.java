package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.SPACE_DELIMETER;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public final class TransformationResult {

  private final Collection<String> transformedOperands;

  private TransformationResult(final Collection<String> transformedOperands) {
    this.transformedOperands = transformedOperands;
  }

  public static TransformationResult create(final Collection<String> transformedOperands) {
    return Objects.nonNull(transformedOperands) && !transformedOperands.isEmpty()
        ? new TransformationResult(transformedOperands) : new TransformationResult(Collections.emptyList());
  }


  public String getTransformedOperandString() {
    return String.join(SPACE_DELIMETER, transformedOperands).trim();
  }

  @Override
  public String toString() {
    return "TransformationResult{" +
        "transformedOperands=" + transformedOperands +
        '}';
  }
}
