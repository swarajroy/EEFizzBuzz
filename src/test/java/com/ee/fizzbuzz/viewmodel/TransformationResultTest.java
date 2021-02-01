package com.ee.fizzbuzz.viewmodel;

import com.ee.fizzbuzz.domain.TransformedOperand;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationResultTest {

    @Test
    public void shouldContainResultStringWithSpacesButNoLeadingAndTrailingSpaces() {
        final TransformationResult input = TransformationResult.create(List.of(
                TransformedOperand.create("1"),
                TransformedOperand.create("2"),
                TransformedOperand.create("3"))
        );

        final String result = input.getTransformedOperandString();

        assertThat(result).isEqualTo("1 2 3");
        assertThat(result).doesNotStartWith(" ");
        assertThat(result).doesNotEndWith(" ");
    }

    @Test
    public void shouldContainEmptyResultString() {
        final TransformationResult result = TransformationResult.create(List.of());

        final String actualStr = result.getTransformedOperandString();

        assertThat(actualStr).isEmpty();
    }


}