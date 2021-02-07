package com.equalexperts.fb;

public final class App {
    public static void main( String[] args ) {
        final FizzBuzzGenerator transformer = new FizzBuzzGenerator(new OperandConverter(new NumberUtils()));

        final TransformedResult result = transformer.transform(1, 20);

        System.out.println(result.getValueAndMetrics());
    }
}
