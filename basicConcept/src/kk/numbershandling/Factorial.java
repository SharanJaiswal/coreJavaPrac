package kk.numbershandling;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    static BigInteger fact (int num) {
        BigInteger ans = new BigInteger("1");
        for (int i = 2; i <= num; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(fact(input.nextInt()));
    }
}
