package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.BUZZ;
import static com.equalexperts.fb.Constants.COLON_DELIMETER;
import static com.equalexperts.fb.Constants.FIZZ;
import static com.equalexperts.fb.Constants.FIZZBUZZ;
import static com.equalexperts.fb.Constants.INTEGER;
import static com.equalexperts.fb.Constants.LUCKY;
import static com.equalexperts.fb.Constants.SPACE_DELIMETER;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

public final class TransformedResult {

  private static final Predicate<String> LUCKY_PREDICATE = value -> value.equals(LUCKY);
  private static final Predicate<String> FIZZ_PREDICATE = value -> value.equals(FIZZ);
  private static final Predicate<String> BUZZ_PREDICATE = value -> value.equals(BUZZ);
  private static final Predicate<String> FIZZBUZZ_PREDICATE = value -> value.equals(FIZZBUZZ);
  private static final Predicate<String> NUMBER_PREDICATE = NumberUtils::isNumeric;


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


  private String getMetricString() {
    final long luckyCount = getCountOn(LUCKY_PREDICATE);
    final long fizzCount = getCountOn(FIZZ_PREDICATE);
    final long buzzCount = getCountOn(BUZZ_PREDICATE);
    final long fizzBuzzCount = getCountOn(FIZZBUZZ_PREDICATE);
    final long numberCount = getCountOn(NUMBER_PREDICATE);

    final String fizzMetric = buildMetricUnit(FIZZ, fizzCount);
    final String buzzMetric = buildMetricUnit(BUZZ, buzzCount);
    final String fizzBuzzMetric = buildMetricUnit(FIZZBUZZ, fizzBuzzCount);
    final String luckyMetric = buildMetricUnit(LUCKY, luckyCount);
    final String numberMetric = buildMetricUnit(INTEGER, numberCount);

    return String.join(SPACE_DELIMETER, fizzMetric, buzzMetric, fizzBuzzMetric, luckyMetric, numberMetric);

  }

  public String getValueAndMetricString() {
    return getValue().concat(SPACE_DELIMETER).concat(getMetricString()).trim();
  }

  private String buildMetricUnit(final String key, final long value) {
    return key.concat(COLON_DELIMETER).concat(SPACE_DELIMETER).concat(String.valueOf(value));
  }

  private long getCountOn(final Predicate<String> criteria) {
    return this.values.stream().filter(criteria).count();
  }
}


