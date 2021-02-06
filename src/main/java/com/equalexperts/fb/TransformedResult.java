package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.SPACE_DELIMETER;

import java.util.Collection;
import java.util.Collections;

public final class TransformedResult {
  private final Collection<String> values;

  private TransformedResult(final Collection<String> values) {
    this.values = values != null && !values.isEmpty() ? values : Collections.emptyList();
  }

  public static TransformedResult create(final Collection<String> values) {
    return new TransformedResult(values);
  }

  public String getValue() {
    return String.join(SPACE_DELIMETER, values).trim();
  }

}
