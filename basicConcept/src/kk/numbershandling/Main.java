package kk.numbershandling;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("00.0000");
        System.out.println(decimalFormat.format(7.9));  // 07.9000  ---- .format method returns string
        System.out.println(decimalFormat.format(8.234689)); // 08.2347 Rounding off will take place if decimal range increases the decided decimal range format
        System.out.println(decimalFormat.format(789.45612793)); // 789.4561 While non-decimal may increase without any truncation of extra digits
        System.out.println(decimalFormat.format(new BigDecimal("65665.457886484861655612793")));    // 65665.4579
        /*
        BigInteger is extended as Object -> java.lang.Number -> java.math.BigInteger extends Number implements Comparable. It is used for handling large numbers in java
        -2^(Integer.MAX_VALUE) to 2^(Integer.MAX_VALUE) {both exclusive}
         */

        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(33);
        BigInteger C = BigInteger.valueOf(2147483647);  // Maximum limit that we can pass to valueOf method. Minimum is -2147483648. It takes long type as input because we are passing integer whose largest value will be the largest value of long type.
        // Consider valueOf() is taking integer value by default, so allowed value of Integers are only allowed in it. While new keyword can take String.
//        System.out.println(new BigInteger("25467.45656"));    // throws NumberFormatException
        BigInteger B = new BigInteger("12345678923456787654");  // Constructor should be called if very large number is present. Also, when passed number is string.

        BigInteger D = BigInteger.TEN;

        // Addition
        BigInteger s = A.add(B);
        System.out.println(s);  // 12345678923456787687
        System.out.println(A.multiply(B));  // 407407404474073992582
        System.out.println(A.divide(B));    // 0 - since integers are terminating, hence
        BigInteger P = new BigInteger("10");
        BigInteger Q = new BigInteger("3");
        System.out.println(P.divide(Q));    // 3 fraction part is dropped off and only number left to the decimal(if exists) are taken, as it is an BigInteger operation
        System.out.println(A.subtract(B));  // -12345678923456787621
        System.out.println(A.remainder(B)); // 33
        System.out.println(B.remainder(A)); // 9
        System.out.println(A.negate()); // -33 and many other math and bit operations

        // For comparing the two values, comparable compareTo() is called with same logic.
        if (A.compareTo(B) > 0) { System.out.println("A > B"); }
        else { System.out.println("B >= A"); }  // B >= A

        // BigDecimal is used because operation on float|double don't give accurate answers. It is accompanied by small errors of order 10^-19. BigDecimal doesn't give any error.
        // Float and double are floating point numbers.
        // These are stored as binary representation of a fraction and an exponent. While Integers are fixed point numbers.
        double f1 = 0.03;
        double f2 = 0.04;
        double ans = f2 - f1;
        System.out.println(ans);    // 0.010000000000000002

        // Object -> java.lang.Number -> java.math.BigDecimal
        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal dans = Y.subtract(X);
        System.out.println(dans);   // 0.01

        BigDecimal p = new BigDecimal("65866884626225632526842.684681352");
        BigDecimal q = new BigDecimal("546556987818356.35156516135561");

        System.out.println(p.add(q));   // 65866885172782620345199.03624651335561
        System.out.println(p.subtract(q));  // 65866884079668644708486.33311619064439
        System.out.println(p.multiply(q));  // 36000006058289086287721759704929839829.89894185427667720758472
//        System.out.println(p.divide(q));    // gives error as this gives non-terminating quotient as answer/
//        System.out.println(decimalFormat.format(p.divide(q)));  // nor this will work, as quotient is non-terminating
        System.out.println(p.divide(q,3, RoundingMode.HALF_DOWN));
        System.out.println(p.negate());

        BigDecimal con = BigDecimal.ONE;

        X = new BigDecimal("10.0");
        Y = new BigDecimal("5.0");
        System.out.println(X.divide(Y));    // no error if the answer has terminating quotient.
        System.out.println(decimalFormat.format(X.divide(Y)));
    }
}
