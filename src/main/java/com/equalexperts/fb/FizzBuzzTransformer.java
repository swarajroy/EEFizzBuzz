package com.equalexperts.fb;

import static java.util.stream.Collectors.toList;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class FizzBuzzTransformer {

  private final OperandConverter operandConverter;

  public FizzBuzzTransformer(final OperandConverter operandConverter) {
    this.operandConverter = operandConverter;
  }

  public TransformationResult transform(final int start, final int endInclusive) {

    return IntStream.rangeClosed(start, endInclusive)
            .mapToObj(operandConverter::convert)
            .collect(Collectors.collectingAndThen(toList(), TransformationResult::create));
  }
}
