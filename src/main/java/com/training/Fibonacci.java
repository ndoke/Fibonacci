package com.training;

import java.util.Arrays;

/**
 * {@link Fibonacci} has methods to calculate n'th Fibonacci number
 * with and without recursion. In case of recursive call, it also
 * has a method to calculate the Fibonacci number using single recursion.
 * {@link Fibonacci#fib(int)} calculates the factorial using iteration,
 * while the other methods ({@link Fibonacci#fibUsingSingleRecursion(int)}
 * & {@link Fibonacci#fibUsingDoubleRecursion(int)}) make use of recursive
 * calls.
 *
 * @author  Nachiket Doke
 * @since   1.0
 */

public class Fibonacci {
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "n cannot be less than 0.";
    private int[] memo;

    Fibonacci() {
        memo = new int[100];
        Arrays.fill(memo, -1);
    }

    /**
     * Returns the n'th Fibonacci number iteratively.
     *
     * @param n element whose ordinal Fibonacci number if to be calculated
     * @return ordinal Fibonacci number of the specified element
     */
    public int fib(int n) {
        if (!isLegalArgument(n)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int two_prev = 0;
        int one_prev = 1;
        int fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = two_prev + one_prev;
            two_prev = one_prev;
            one_prev = fib;
        }
        return fib;
    }

    /**
     * Returns the n'th Fibonacci number using two recursions.
     *
     * @param n element whose ordinal Fibonacci number if to be calculated
     * @return ordinal Fibonacci number of the specified element
     */
    public int fibUsingDoubleRecursion(int n) {
        if (!isLegalArgument(n)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        if (memo[n] > -1) {
            return memo[n];
        }

        memo[n] = fibUsingDoubleRecursion(n - 2) + fibUsingDoubleRecursion(n - 1);
        return memo[n];
    }

    /**
     * Returns the n'th Fibonacci number using one recursion.
     *
     * @param n element whose ordinal Fibonacci number if to be calculated
     * @return ordinal Fibonacci number of the specified element
     */
    public int fibUsingSingleRecursion(int n) {
        if (!isLegalArgument(n)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }

        return fibHelper(n, 0, 1);
    }

    private int fibHelper(int n, int current_first, int current_second) {
        if (n == 0) {
            return current_first;
        }

        int current_third = current_first + current_second;
        return fibHelper(n - 1, current_second, current_third);
    }

    private boolean isLegalArgument(int n) {
        return n >= 0;
    }
}
