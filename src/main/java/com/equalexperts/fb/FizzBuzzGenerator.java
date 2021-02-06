package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.SPACE_DELIMETER;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class FizzBuzzGenerator {

  private final OperandConverter operandConverter;

  public FizzBuzzGenerator(final OperandConverter operandConverter) {
    this.operandConverter = operandConverter;
  }

  public String transform(final int start, final int endInclusive) {

    return IntStream.rangeClosed(start, endInclusive)
            .mapToObj(operandConverter::convert)
            .collect(Collectors.joining(SPACE_DELIMETER));
  }
}
