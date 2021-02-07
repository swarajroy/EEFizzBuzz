package com.equalexperts.fb;

import java.util.Scanner;

public class NumberUtils {

  public boolean contains3(int number) {
    while (number > 0) {
      if (number % 10 == 3) {
        return true;
      }
      number = number/10;
    }
    return false;
  }

  public boolean multipleOf15(int number) {
    return multipleOf5(number) && multipleOf3(number);
  }

  public boolean multipleOf5(int number) {
    return number % 5 == 0;
  }

  public boolean multipleOf3(int number) {
    return number % 3 == 0;
  }

  public static boolean isNumeric(final String operand) {

    if (operand == null || operand.isEmpty()) {
      return false;
    }

    return operand.chars().allMatch(Character::isDigit);
  }
}
