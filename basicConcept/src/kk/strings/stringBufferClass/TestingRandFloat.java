package kk.strings.stringBufferClass;

import java.util.Random;

public class TestingRandFloat {
    public static void main(String[] args) {
        Random random = new Random();

        int count = 10, itr = 0;

        while(count != 0) {
            float randFloat = random.nextFloat();
            if (randFloat < 0.0001f && randFloat > 0.000001f) {
                System.out.println((int) (randFloat * 26) + " ================== " + (int) (randFloat * 1000000 % 26));
                // We are multiplying by 10^6 because there could be random float generated as 0.000001. So, multiplying just by 100 would also give all the time 0 as an answer
                count--;
            }
            itr++;
        }
        System.out.printf("" + itr);
    }
}
