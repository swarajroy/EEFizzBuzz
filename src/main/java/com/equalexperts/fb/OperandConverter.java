package com.equalexperts.fb;

import static com.equalexperts.fb.Constants.BUZZ;
import static com.equalexperts.fb.Constants.FIZZ;
import static com.equalexperts.fb.Constants.FIZZBUZZ;

public class OperandConverter {

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
