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
import org.apache.commons.lang3.StringUtils;

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


  public TransformedResult buildReport() {
    final long luckyCount = this.values.stream().filter(operand -> operand.equals(LUCKY)).count();
    final long fizzCount = this.values.stream().filter(operand -> operand.equals(FIZZ)).count();
    final long buzzCount = this.values.stream().filter(operand -> operand.equals(BUZZ)).count();
    final long fizzBuzzCount = this.values.stream().filter(operand -> operand.equals(FIZZBUZZ)).count();
    final long numberCount = this.values.stream().filter(StringUtils::isNumeric).count();

    this.values.add(FIZZ.concat(COLON_DELIMETER).concat(SPACE_DELIMETER).concat(String.valueOf(fizzCount)));
    this.values.add(BUZZ.concat(COLON_DELIMETER).concat(SPACE_DELIMETER).concat(String.valueOf(buzzCount)));
    this.values.add(FIZZBUZZ.concat(COLON_DELIMETER).concat(SPACE_DELIMETER).concat(String.valueOf(fizzBuzzCount)));
    this.values.add(LUCKY.concat(COLON_DELIMETER).concat(SPACE_DELIMETER).concat(String.valueOf(luckyCount)));
    this.values.add(INTEGER.concat(COLON_DELIMETER).concat(SPACE_DELIMETER).concat(String.valueOf(numberCount)));

    return this;
  }
}
