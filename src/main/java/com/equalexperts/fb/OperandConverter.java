package com.equalexperts.fb;

public class OperandConverter {

  private static final String FIZZBUZZ = "fizzbuzz";
  private static final String FIZZ = "fizz";
  private static final String BUZZ = "buzz";

  public String convert(final int operand) {

    if (operand % 3 == 0 && operand % 5 == 0) {
      return FIZZBUZZ;
    } else if (operand % 3 == 0) {
      return FIZZ;
    } else if (operand % 5 == 0) {
      return BUZZ;
    } else {
      return String.valueOf(operand);
    }
  }
}
