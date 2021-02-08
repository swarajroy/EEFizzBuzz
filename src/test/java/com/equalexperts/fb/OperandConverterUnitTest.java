package com.equalexperts.fb;

import static com.equalexperts.fb.FizzBuzzTestFixture.BUZZ;
import static com.equalexperts.fb.FizzBuzzTestFixture.FIZZ;
import static com.equalexperts.fb.FizzBuzzTestFixture.FIZZBUZZ;
import static com.equalexperts.fb.FizzBuzzTestFixture.LUCKY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class OperandConverterUnitTest {

  private OperandConverter subjectUnderTest;

  @Mock
  private NumberUtils numberUtils;

  @BeforeEach
  public void setUp() {
    this.subjectUnderTest = new OperandConverter(numberUtils);
  }

  @Test
  @DisplayName("expect the contains3 case to pass, verify LUCKY is returned and verify interactions with numberUtils")
  public void expectLuckyAndVerifyInvocations() {
    when(numberUtils.contains3(anyInt())).thenReturn(true);

    assertThat(this.subjectUnderTest.convert(3)).isEqualTo(LUCKY);

    verify(numberUtils , times(1)).contains3(anyInt());
    verifyNoMoreInteractions(numberUtils);
  }

  @Test
  @DisplayName("expect the multipleOf15 case to pass, verify FIZZBUZZ is returned and verify interactions with numberUtils")
  public void expectFizzBuzzAndVerifyInvocations() {
    when(numberUtils.contains3(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf15(anyInt())).thenReturn(true);

    assertThat(this.subjectUnderTest.convert(5)).isEqualTo(FIZZBUZZ);

    verify(numberUtils , times(1)).multipleOf15(anyInt());
    verify(numberUtils, times(1)).contains3(anyInt());
    verifyNoMoreInteractions(numberUtils);
  }

  @Test
  @DisplayName("expect the multipleOf3 case to pass, verify FIZZ is returned and verify interactions with numberUtils")
  public void expectFizzAndVerifyInvocations() {
    when(numberUtils.contains3(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf15(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf3(anyInt())).thenReturn(true);

    assertThat(this.subjectUnderTest.convert(6)).isEqualTo(FIZZ);

    verify(numberUtils , times(1)).multipleOf3(anyInt());
    verify(numberUtils, times(1)).multipleOf15(anyInt());
    verify(numberUtils, times(1)).contains3(anyInt());
    verifyNoMoreInteractions(numberUtils);
  }

  @Test
  @DisplayName("expect the multipleOf5 case to pass, verify BUZZ is returned and verify interactions with numberUtils")
  public void expectBuzzAndVerifyInvocations() {
    when(numberUtils.contains3(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf15(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf3(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf5(anyInt())).thenReturn(true);

    assertThat(this.subjectUnderTest.convert(5)).isEqualTo(BUZZ);

    verify(numberUtils , times(1)).multipleOf5(anyInt());
    verify(numberUtils , times(1)).multipleOf3(anyInt());
    verify(numberUtils, times(1)).multipleOf15(anyInt());
    verify(numberUtils, times(1)).contains3(anyInt());
    verifyNoMoreInteractions(numberUtils);
  }

  @DisplayName("expect the numbers case to pass, verify the number is returned and verify interactions with numberUtils")
  @ParameterizedTest
  @MethodSource("com.equalexperts.fb.FizzBuzzTestFixture#numbers")
  public void expectNumberAndVerifyInvocations(final int input, final String result) {
    when(numberUtils.contains3(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf15(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf3(anyInt())).thenReturn(false);
    when(numberUtils.multipleOf5(anyInt())).thenReturn(false);

    assertThat(this.subjectUnderTest.convert(input)).isEqualTo(result);

    verify(numberUtils , times(1)).multipleOf5(anyInt());
    verify(numberUtils , times(1)).multipleOf3(anyInt());
    verify(numberUtils, times(1)).multipleOf15(anyInt());
    verify(numberUtils, times(1)).contains3(anyInt());
    verifyNoMoreInteractions(numberUtils);
  }


  
}