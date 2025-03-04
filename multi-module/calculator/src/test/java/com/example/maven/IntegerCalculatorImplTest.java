package com.example.maven;

import com.example.maven.calculator.Calculator;
import com.example.maven.calculator.IntegerCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class IntegerCalculatorImplTest {

    public static final double EPSILON = 0.001;

    @Test
    public void shouldImplementsCalculator() {
        Assert.assertTrue(new IntegerCalculatorImpl() instanceof Calculator);
    }

    @Test
    public void shouldSumsTwoIntegers() {
        Assert.assertEquals((Integer) 2, new IntegerCalculatorImpl().sum(1, 1));
        Assert.assertEquals((Integer) 21, new IntegerCalculatorImpl().sum(1, 20));
    }

    @Test
    public void shouldSumsTwoIntegersWithNegative() {
        Assert.assertEquals((Integer) 0, new IntegerCalculatorImpl().sum(1, -1));
        Assert.assertEquals((Integer) 19, new IntegerCalculatorImpl().sum(-1, 20));
    }

    @Test
    public void shouldSumsTwoIntegersWithBothNegative() {
        Assert.assertEquals((Integer) (-2), new IntegerCalculatorImpl().sum(-1, -1));
        Assert.assertEquals((Integer) (-21), new IntegerCalculatorImpl().sum(-1, -20));
    }

    @Test(expected = ArithmeticException.class)
    public void shouldNotAllowSumToOverflow() {
        new IntegerCalculatorImpl().sum(1, Integer.MAX_VALUE);
        Assert.fail("Sum overflow should not be allowed");
    }

    @Test(expected = ArithmeticException.class)
    public void shouldNotAllowSumToOverflowSummingIntegerMaxValue() {
        new IntegerCalculatorImpl().sum(2, Integer.MAX_VALUE - 1);
        Assert.fail("Sum overflow should not be allowed");
    }

    @Test
    public void shouldSumToIntegerMaxValue() {
        Assert.assertEquals((Integer) Integer.MAX_VALUE, new IntegerCalculatorImpl().sum(1, Integer.MAX_VALUE - 1));
    }

    @Test
    public void shouldSumIntegerMaxValueWithNegativeIntegerMaxValueEqualsZero() {
        Assert.assertEquals((Integer) 0, new IntegerCalculatorImpl().sum(-Integer.MAX_VALUE, Integer.MAX_VALUE));
    }


    @Test
    public void shouldCalculatesDifferenceTwoIntegers() {
        Assert.assertEquals((Integer) 0, new IntegerCalculatorImpl().difference(1, 1));
        Assert.assertEquals((Integer) (-19), new IntegerCalculatorImpl().difference(1, 20));
    }

    @Test
    public void shouldCalculatesDifferenceTwoIntegersWithNegative() {
        Assert.assertEquals((Integer) 2, new IntegerCalculatorImpl().difference(1, -1));
        Assert.assertEquals((Integer) (-21), new IntegerCalculatorImpl().difference(-1, 20));
    }

    @Test
    public void shouldCalculatesDifferenceTwoIntegersWithBothNegative() {
        Assert.assertEquals((Integer) 0, new IntegerCalculatorImpl().difference(-1, -1));
        Assert.assertEquals((Integer) 19, new IntegerCalculatorImpl().difference(-1, -20));
    }

    @Test(expected = ArithmeticException.class)
    public void shouldNotAllowDifferenceToOverflow() {
        new IntegerCalculatorImpl().difference(Integer.MIN_VALUE, 1);
        Assert.fail("Difference overflow should not be allowed");
    }

    @Test
    public void shouldDifferenceIntegerMaxValueWithNegativeIntegerMaxValueEqualsZero() {
        Assert.assertEquals((Integer) 0, new IntegerCalculatorImpl().difference(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void shouldReturnTwoWhenMultiplyingTwoByOne() {
        Assert.assertEquals((Integer) 2, new IntegerCalculatorImpl().product(1, 2));
    }

    @Test
    public void shouldReturnFourWhenMultiplyingTwoByTwo() {
        Assert.assertEquals((Integer) 4, new IntegerCalculatorImpl().product(2, 2));
    }

    @Test
    public void shouldReturnZeroWhenMultiplyingAnyNumberByZero() {
        Assert.assertEquals((Integer) 0, new IntegerCalculatorImpl().product(2, 0));
    }

    @Test
    public void shouldReturnOneHundredWhenMultiplyingTenByTen() {
        Assert.assertEquals((Integer) 100, new IntegerCalculatorImpl().product(10, 10));
    }

    @Test
    public void shouldReturnNegativeWhenOnlyOneOfOperandsIsNegative() {
        Assert.assertEquals((Integer) (-30), new IntegerCalculatorImpl().product(6, -5));
    }

    @Test
    public void shouldReturnOneWhenDividingOneByOne() {
        Assert.assertEquals((Double) 1D, new IntegerCalculatorImpl().quotient(1, 1));
    }

    @Test
    public void shouldReturnTwoWhenDividingFourByTwo() {
        Assert.assertEquals((Double) 2D, new IntegerCalculatorImpl().quotient(4, 2));
    }

    @Test
    public void shouldReturnFiveWhenDividingTenByTwo() {
        Assert.assertEquals((Double) 5D, new IntegerCalculatorImpl().quotient(10, 2));
    }

    @Test
    public void shouldReturnZeroDotFiveWhenDividing1ByTwo() {
        Assert.assertEquals((Double) 0.5, new IntegerCalculatorImpl().quotient(1, 2));
    }

    @Test
    public void shouldReturnZeroDotTwentyFiveWhenDividingOneByFour() {
        Assert.assertEquals((Double) 0.25, new IntegerCalculatorImpl().quotient(1, 4));
    }

    @Test
    public void shouldReturnNegativeWhenTheDividendIsNegative() {
        Assert.assertEquals(-0.7777, new IntegerCalculatorImpl().quotient(-7, 9), EPSILON);
    }

    @Test
    public void shouldReturnNegativeWhenTheDivisorIsNegative() {
        Assert.assertEquals(-1.615384, new IntegerCalculatorImpl().quotient(21, -13), EPSILON);
    }

}
