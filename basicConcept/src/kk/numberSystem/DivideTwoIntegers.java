package kk.numberSystem;

import org.w3c.dom.ls.LSOutput;

/**
 * We need to divide 2 integers. Catch is we cannot use division or modulo operator.
 * Brute force approach: iteratively add divisor to some ZERO, until it exceeds dividend; and while doing this, on every iteration increase the counter. Answer will be counter where sum the max and <= dividend. TC:2^31 this might give TLE in most of the cases.
 * Better Approach: Any number can be expressed as the sum of unique powers of 2. We will define dividend as divisor*(sum of unique powers of 2). S, we'll find max power of 2 where divisor*(2^power) will be <= dividend.
 * We'll reduce that divisor*(2^power) from dividend, and in answer variable (initially as 0) we'll add this divisor*(2^power). We'll do this till we have dividend >= divisor.
 * Edge cases: A division can only be negative when either divisor is negative or dividend is negative, else non-negative in every case, if divisor is non-zero.
 * In case where dividend is Integer.MIN_VALUE(-2^31) and divisor is -1, then answer will be Integer.MAX_VALUE+1 (2^31); giving overflow condition. In such cases, return Integer.MAX_VALUE (Its wrong, but it is what it is)
 * Other edge case would be when dividend==divisor, then in such cases, we need to return 1;
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {

    }

    private static void division(int dividend, int divisor) {
        if (dividend == divisor) {
            System.out.println("1");
            return;
        }

        boolean isPositive = true;
        if ((dividend < 0 && divisor > 0) || (dividend >= 0 && divisor < 0)) {
            isPositive = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int count = 0;
        long answer = 0;
        while (dividend >= divisor) {
            count = 0;
            while (divisor << (count + 1) <= dividend) {
                count++;
            }
            answer += (1 << count);
            dividend -= (divisor * (1 << count));
        }
        if (answer > Integer.MAX_VALUE && isPositive == true) {
            System.out.println(Integer.MAX_VALUE);
            return;
        } else if (answer > Integer.MAX_VALUE && isPositive == false) {
            System.out.println(Integer.MIN_VALUE);
            return;
        }
        System.out.println(isPositive ? answer : "-" + answer);
    }
}

/**
 * TIME COMPLEXITY: (log2(N))^2
 * Outer while loop has Log2(N). Reason: Divisor is getting reduced from dividend. Divisor is getting increased by double. So, vaguely, dividend is getting reduced by power of 2.
 * Inner while loop has log2(N). Reason: Divisor is getting increased by double.
 */
