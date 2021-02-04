package com.equalexperts.fb;

/**
 *
 * Entry point
 *
 */
public class App {
    public static void main( String[] args ) {
        final FizzBuzzTransformer transformer = new FizzBuzzTransformer(new OperandConverter());
        final TransformationResult result = transformer.transform(1, 20);
        System.out.println(result.getTransformedOperandString());
    }
}
