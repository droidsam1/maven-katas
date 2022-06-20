package com.example.maven;

import com.example.maven.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class IntegerCalculatorImplTest {

    @Test
    public void IntegerCaculatorImplementsCalculatorInterface() {
        Assert.assertTrue(new IntegerCalculatorImpl() instanceof Calculator);
    }
}
