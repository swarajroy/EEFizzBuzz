package com.equalexperts.fb.domain;

import java.util.Objects;

public final class TransformedOperand {
  private final String value;

  private TransformedOperand(final String value) {
    this.value = value;
  }

  public static TransformedOperand create(final String value) {
    return new TransformedOperand(value);
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransformedOperand that = (TransformedOperand) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "TransformedOperand{" + "value='" + value + '\'' + '}';
  }
}
