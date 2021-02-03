package com.equalexperts.fb.converter;

import static com.equalexperts.fb.Constants.BUZZ;
import static com.equalexperts.fb.Constants.FIZZ;
import static com.equalexperts.fb.Constants.FIZZBUZZ;

import com.equalexperts.fb.domain.TransformedOperand;

public class OperandConverter {

  public TransformedOperand convert(final int operand) {

    if (operand % 3 == 0 && operand % 5 == 0) {
      return TransformedOperand.create(FIZZBUZZ);
    } else if (operand % 3 == 0) {
      return TransformedOperand.create(FIZZ);
    } else if (operand % 5 == 0) {
      return TransformedOperand.create(BUZZ);
    } else {
      return TransformedOperand.create(String.valueOf(operand));
    }
  }
}
