package kk.numberSystem;

import java.util.Scanner;

// Given a number in decimal format. Convert it into Binary format. To convert binary to magic number, replicate process of binary to decimal but using powers of 5
public class MagicNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        // No Of Digits //
        noOfDigits(n, 2);
        noOfDigits(n, 10);
        noOfDigits(n, 3);
        //
        //
        //

        int magicNum = 0;
        int counter = 1;
        while(n != 0) {
            int lsb = n & 1;

//            System.out.println(lsb + " * * * " + (int)Math.pow(5, counter));

            magicNum += lsb * (int)Math.pow(5, counter++);

            n = n >> 1;
        }
        System.out.println(magicNum);
    }

    static void noOfDigits(int N, int base) {
        System.out.println(1 + (int)(Math.log(N) / Math.log(base)));
    }

}
