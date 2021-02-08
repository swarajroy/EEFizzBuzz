package com.equalexperts.fb;

public class OperandConverter {

  private static final String FIZZBUZZ = "fizzbuzz";
  private static final String FIZZ = "fizz";
  private static final String BUZZ = "buzz";
  private static final String LUCKY = "lucky";

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
