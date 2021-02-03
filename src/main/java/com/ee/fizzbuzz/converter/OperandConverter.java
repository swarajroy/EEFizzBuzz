package com.ee.fizzbuzz.converter;

import static com.ee.fizzbuzz.Constants.BUZZ;
import static com.ee.fizzbuzz.Constants.FIZZ;
import static com.ee.fizzbuzz.Constants.FIZZBUZZ;

import com.ee.fizzbuzz.domain.TransformedOperand;

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
