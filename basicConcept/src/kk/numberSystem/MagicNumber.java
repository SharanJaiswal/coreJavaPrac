package kk.numberSystem;

import java.util.Scanner;

// Given a number in decimal format. Convert it into Binary format. To convert binary to magic number, replicate process of binary to decimal but using powers of 5
public class MagicNumber {
    public static void main(String[] args) {

        int n = 13;
        // No Of Digits //
        noOfDigits(n, 2);
        noOfDigits(n, 10);
        noOfDigits(n, 3);

        System.out.println(decimalToBaseBNumber(319, 16));
    }

    private static void noOfDigits(int N, int base) {
        // We can find number of digits of any number 'n' of base 'b' using LOGb(n)+1.
        // We are adding 1 to the log value because while continuously dividing 'n' by 'b', at last we are left with 1. So, division happens only for LOGb(n) times.
        // The remaining last 1 is the MSB, which is at the left-most of the number, if number represented in base 'b'.
        System.out.println(1 + (int)(Math.log(N) / Math.log(base)));
    }

    private static StringBuilder decimalToBaseBNumber(int num, int base) {
        StringBuilder ans = new StringBuilder();
        while (num >= 1) {
            int remainder = num % base;
            if (remainder > 9) {
                ans = ans.append((char)(remainder - 9 - 1 + 97)); // remainder>9 ie  1 for 10, 2 for 11, 3 for 12.... So, A for 1, B for 2, C for 3, D for 4.... Subtracted 1 because for 10 => 1 => 97+1 => 'B' not 'A', but correct is 'A'. So, subtracted 1
            } else {
                ans = ans.append(remainder);
            }
            num /= base;
        }
        return ans.reverse();
    }

    // Below method can be implemented logically by 2 ways. One is given below, suitable if we are parsing base 'b' number from left.
    // Another method will be suitable if we are parsing number digit by digit from right. In this case, initially ans=sum of product of each digit and base^(idx of digit from right starting from 0)
    // Second method is more suitable if base 'b' number is in numerical format rather than being string, so that we can apply % (remainder) operation.
    private static long baseBToDecimalNumber(String num, int base) {
        long answer = 0;
        char digit;
        for (int i = 0; i < num.length(); i++) {
            digit = num.charAt(i);
            if (digit >= 'A') {
                answer = answer * base + digit - 'A' + 1;
            } else {
                answer = answer * base + Long.parseLong(digit + "");
            }
        }
        return answer;
    }
}
