package com.example.maven;

import org.junit.Assert;
import org.junit.Test;

public class IntegerCalculatorImplTest {

    @Test
    public void IntegerCaculatorImplementationExists(){
        Assert.assertNotNull(new IntegerCalculatorImpl());
    }
}
