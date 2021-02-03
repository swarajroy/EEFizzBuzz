package com.ee.fizzbuzz;

import com.ee.fizzbuzz.converter.OperandConverter;
import com.ee.fizzbuzz.viewmodel.TransformationResult;
import com.ee.fizzbuzz.tranformer.FizzBuzzTransformer;
import com.ee.fizzbuzz.validator.RangeBoundValidator;

/**
 *
 * Entry point
 *
 */
public class App {
    public static void main( String[] args ) {
        final FizzBuzzTransformer transformer = new FizzBuzzTransformer(new OperandConverter(), new RangeBoundValidator());
        final TransformationResult result = transformer.transform(1, 20);
        System.out.println(result.getTransformedOperandString());
    }
}
