package kk.numbershandling;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("00.0000");
        System.out.println(decimalFormat.format(7.9));
        System.out.println(decimalFormat.format(8.234689)); // Rounding off will take place if decimal range increases the decided decimal range format
        System.out.println(decimalFormat.format(789.45612793)); // While non-decimal may increase without any truncation of extra digits

        /*
        BigInteger is extended as Object -> java.lang.Number -> java.math.BigInteger extends Number implements Comparable. It is used for handling large numbers in java
        -2^(Integer.MAX_VALUE) to 2^(Integer.MAX_VALUE) {both exclusive}
         */

        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(33);
        BigInteger C = BigInteger.valueOf(2147483647);  // Maximum limit that we can pass to valueOf method. Minimum is -2147483648. It takes long type as input
        BigInteger B = new BigInteger("12345678923456787654");  // Constructor should be called if very large number is present. Also, when passed number is string

        BigInteger D = BigInteger.TEN;

        // Addition
        BigInteger s = A.add(B);
        System.out.println(s);
        System.out.println(A.multiply(B));
        System.out.println(A.divide(B));
        System.out.println(A.subtract(B));
        System.out.println(A.remainder(B));

        // For comparing the two values, comparable compareTo() is called with same logic.
        if (A.compareTo(B) > 0){
            System.out.println("A > B"); } else {
            System.out.println("B > A"); }

        // BigDecimal is used because operation on float/double don't give accurate answers. It is accompanied by small errors of order 10^-19. BigDecimal doesn't give nay error.
        // Float and double are floating point numbers.
        // These are stored as binary representation of a fraction and an exponent. While Integers are fixed point numbers.
        double f1 = 0.03;
        double f2 = 0.04;
        double ans = f2 - f1;
        System.out.println(ans);

        // Object -> java.lang.Number -> java.math.BigDecimal
        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal dans = Y.subtract(X);
        System.out.println(dans);

        BigDecimal p = new BigDecimal("65866884626225632526842.684681352");
        BigDecimal q = new BigDecimal("546556987818356.35156516135561");

        System.out.println(p.add(q));
        System.out.println(p.subtract(q));
        System.out.println(p.multiply(q));
//        System.out.println(p.divide(q));
        System.out.println(p.negate());

        BigDecimal con = BigDecimal.ONE;
    }
}
