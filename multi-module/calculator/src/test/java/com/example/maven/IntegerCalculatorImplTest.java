package com.example.maven;

import com.example.maven.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

public class IntegerCalculatorImplTest {

    @Test
    public void IntegerCaculatorImplementsCalculatorInterface() {
        Assert.assertTrue(new IntegerCalculatorImpl() instanceof Calculator);
    }

    @Test
    public void IntegerCalculatorSumsTwoIntegers() {
        Assert.assertEquals((Integer) 2, new IntegerCalculatorImpl().sum(1, 1));
        Assert.assertEquals((Integer) 21, new IntegerCalculatorImpl().sum(1, 20));
    }

    @Test
    public void IntegerCalculatorSumsTwoIntegersWithNegative() {
        Assert.assertEquals((Integer) 0, new IntegerCalculatorImpl().sum(1, -1));
        Assert.assertEquals((Integer) 19, new IntegerCalculatorImpl().sum(-1, 20));
    }

    @Test
    public void IntegerCalculatorSumsTwoIntegersWithBothNegative() {
        Assert.assertEquals((Integer) (-2), new IntegerCalculatorImpl().sum(-1, -1));
        Assert.assertEquals((Integer) (-21), new IntegerCalculatorImpl().sum(-1, -20));
    }

    @Test(expected = InvalidParameterException.class)
    public void IntegerCalculatorShouldNotAllowSumToOverflow() {
        new IntegerCalculatorImpl().sum(1, Integer.MAX_VALUE);
        Assert.fail("Sum overflow should not be allowed");
    }

    @Test(expected = InvalidParameterException.class)
    public void IntegerCalculatorShouldNotAllowSumToOverflowSummingIntegerMaxValue() {
        new IntegerCalculatorImpl().sum(2, Integer.MAX_VALUE - 1);
        Assert.fail("Sum overflow should not be allowed");
    }

    @Test
    public void IntegerCalculatorShouldSumToIntegerMaxValue() {
        Assert.assertEquals((Integer) Integer.MAX_VALUE, new IntegerCalculatorImpl().sum(1, Integer.MAX_VALUE - 1));
    }

    @Test
    public void IntegerCalculatorSumIntegerMaxValueWithNegativeIntegerMaxValueEqualsZero() {
        Assert.assertEquals((Integer) 0, new IntegerCalculatorImpl().sum(-Integer.MAX_VALUE, Integer.MAX_VALUE));
    }


}
