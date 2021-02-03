package com.equalexperts.fb.validator;

public class RangeBoundValidator {
    public boolean isValid(final int start, final int endInclusive) {
        return (start > 0 && endInclusive > 0) && (endInclusive > start);
    }
}
