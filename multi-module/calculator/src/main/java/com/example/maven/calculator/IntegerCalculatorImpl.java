package com.example.maven.calculator;

public class IntegerCalculatorImpl implements Calculator<Integer> {
    @Override
    public Integer sum(Integer integer, Integer t1) {
        if (((long) integer + t1) > Integer.MAX_VALUE) {
            throw new ArithmeticException();
        }
        return integer + t1;
    }

    @Override
    public Integer difference(Integer integer, Integer t1) {
        if (((long) integer - t1) < Integer.MIN_VALUE) {
            throw new ArithmeticException();
        }
        return integer - t1;
    }

    @Override
    public Integer product(Integer integer, Integer t1) {
        return integer * t1;
    }

    @Override
    public Double quotient(Integer integer, Integer t1) {
        return integer.doubleValue() / t1;
    }
}
