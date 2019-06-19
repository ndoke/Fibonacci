package com.training;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class FibonacciTest {
    private Map<Integer, Integer> in_out = new HashMap<>();
    private Fibonacci fibonacci = new Fibonacci();

    @BeforeClass
    public void setUp() {
        in_out.put(0, 0);
        in_out.put(1, 1);
        in_out.put(4, 3);
        in_out.put(8, 21);
        in_out.put(10, 55);
    }

    @Test
    public void legalCases() {
        for (Map.Entry<Integer, Integer> entry : in_out.entrySet()) {
            int input = entry.getKey();
            int output = entry.getValue();
            Assert.assertEquals(fibonacci.fib(input), output);
            Assert.assertEquals(fibonacci.fibUsingDoubleRecursion(input), output);
            Assert.assertEquals(fibonacci.fibUsingSingleRecursion(input), output);
            Assert.assertEquals(fibonacci.fib(input), output);
        }
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void illegalCase1() throws IllegalArgumentException {
        fibonacci.fib(-3);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void illegalCase2() throws IllegalArgumentException {
        fibonacci.fibUsingDoubleRecursion(-3);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void illegalCase3() throws IllegalArgumentException {
        fibonacci.fibUsingSingleRecursion(-3);
    }
}
