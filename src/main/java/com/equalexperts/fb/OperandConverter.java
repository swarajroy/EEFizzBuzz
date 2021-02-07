package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.BUZZ;
import static com.equalexperts.fb.Constants.FIZZ;
import static com.equalexperts.fb.Constants.FIZZBUZZ;
import static com.equalexperts.fb.Constants.LUCKY;

public class OperandConverter {

  private final NumberUtils numberUtils;

  public OperandConverter(final NumberUtils numberUtils) {
    this.numberUtils = numberUtils;
  }

  public String convert(final int operand) {

    if (numberUtils.contains3(operand)) {
      return LUCKY;
    } else if (numberUtils.multipleOf15(operand)) {
      return FIZZBUZZ;
    } else if (numberUtils.multipleOf3(operand)) {
      return FIZZ;
    } else if (numberUtils.multipleOf5(operand)) {
      return BUZZ;
    } else {
      return String.valueOf(operand);
    }
  }
}
