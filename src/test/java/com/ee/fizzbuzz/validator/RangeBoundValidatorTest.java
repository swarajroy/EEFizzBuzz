package com.ee.fizzbuzz.validator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangeBoundValidatorTest {

    private RangeBoundValidator subjectUnderTest;

    @Before
    public void setUp() {
        this.subjectUnderTest = new RangeBoundValidator();
    }

    @Test
    public void test() {
        assertThat(this.subjectUnderTest.isValid(0, 0)).isFalse();
        assertThat(this.subjectUnderTest.isValid(-1, 0)).isFalse();
        assertThat(this.subjectUnderTest.isValid(0, -1)).isFalse();
        assertThat(this.subjectUnderTest.isValid(-1, -1)).isFalse();
        assertThat(this.subjectUnderTest.isValid(0, 1)).isFalse();
        assertThat(this.subjectUnderTest.isValid(1, 0)).isFalse();
        assertThat(this.subjectUnderTest.isValid(1, -1)).isFalse();
        assertThat(this.subjectUnderTest.isValid(-1, 1)).isFalse();

        assertThat(this.subjectUnderTest.isValid(1, 20)).isTrue();
    }

}