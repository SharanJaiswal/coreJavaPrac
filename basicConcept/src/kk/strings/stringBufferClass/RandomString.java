package kk.strings.stringBufferClass;

import java.util.*;
import java.util.stream.Collectors;

public class RandomString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(RandomString.generate(input.nextInt()));


        // Random class also has methods to give streams of few primitive types:
        Random randomStreams = new Random();
        System.out.println(Arrays.asList(randomStreams.doubles(3)));
    }
    static String generate (int size) {
        Random random = new Random();
        System.out.println(random.nextFloat());     // Return a float between [0.000000000f , 1f)

        StringBuffer strBuf = new StringBuffer();
        int count = 0;  // To only check if post decrement operator when executes. It executes after the expression gets evaluated as if no post-decrement operator is present.
        while(size-- != 0) {
//            strBuf.append((char) (97 + (int) (random.nextFloat() * 26)));   // See TestingRandFloat class in this package
            strBuf.append((char) (97 + (int) (random.nextFloat() * 100 % 26)));
            // The above is somewhat wrong, as there could be possibility where (int)(random.nextFloat()*26) gives 0 most of the times.
            count++;
        }
        return strBuf.toString() + " " + count;
        // There is no need to write toString as second operand of first operator '+' from left is also a String, which makes first operand a String.
    }
}
