package kk.stringBufferClass;

import java.util.Random;
import java.util.Scanner;

public class RandomString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(RandomString.generate(input.nextInt()));
    }
    static String generate (int size) {
        Random random = new Random();
        System.out.println(random.nextFloat());     // Return a float between [0.000000f , 1f)

        StringBuffer strBuf = new StringBuffer();
        int count = 0;  // To only check if post decrement operator when executes. It executes after the expression gets evaluated as if no post-decrement operator is present.
        while(size-- != 0) {
            strBuf.append((char) (97 + (int) (random.nextFloat() * 26)));
            count++;
        }
        return strBuf.toString() + " " + count;
    }
}
