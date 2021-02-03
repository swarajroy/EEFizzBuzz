package com.ee.fizzbuzz.tranformer;

import com.ee.fizzbuzz.converter.OperandConverter;
import com.ee.fizzbuzz.viewmodel.TransformationResult;
import com.ee.fizzbuzz.validator.RangeBoundValidator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.ee.fizzbuzz.Constants.MESSAGE;
import static java.util.stream.Collectors.toList;

public final class FizzBuzzTransformer {

  private final OperandConverter operandConverter;
  private final RangeBoundValidator rangeBoundValidator;

  public FizzBuzzTransformer(final OperandConverter operandConverter, final RangeBoundValidator rangeBoundValidator) {
    this.operandConverter = operandConverter;
    this.rangeBoundValidator = rangeBoundValidator;
  }

  public TransformationResult transform(final int start, final int endInclusive) {
    if (!rangeBoundValidator.isValid(start, endInclusive)) {
      throw new IndexOutOfBoundsException(MESSAGE);
    }

    return IntStream.rangeClosed(start, endInclusive)
            .mapToObj(operandConverter::convert)
            .collect(Collectors.collectingAndThen(toList(), TransformationResult::create));
  }
}
