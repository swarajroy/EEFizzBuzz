package com.equalexperts.fb;

import com.equalexperts.fb.converter.OperandConverter;
import com.equalexperts.fb.viewmodel.TransformationResult;
import com.equalexperts.fb.tranformer.FizzBuzzTransformer;
import com.equalexperts.fb.validator.RangeBoundValidator;

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
