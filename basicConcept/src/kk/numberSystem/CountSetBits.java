package kk.numberSystem;
/*
THIS IS ONLY TRUE FOR NON-NEGATIVE INTEGERS. iF NEGATIVE INTEGERS ARE PRESENT IN SCOPE, BETTER CONVERT NEGATIVE TO POSITIVE AND THEN CHECK IF IT IS NOT REQUIRED TO CHECK ITS 2COMPLIMENT
One way could be brute force approach of Log(n) time complexity where N is the number of bits in the binary representation of the number, where counter is increased on every set bit.
Second approach will be,
 */
public class CountSetBits {
    public static void main(String[] args) {
        int n = 45;

        System.out.println(Integer.toBinaryString(n));

        System.out.println(setBitsCount(n));
    }

    private static int setBitsCount(int n) {
        int count = 0;

        while (n > 0) {
            // NOTE: we directly incremented count by 1, and not checked if the set bit is not equal to zero.
            // It is because, if set bit (N & -N) will be zero, then N itself will be zero.
            count++;
//            n -= (n & (-n));
            n = n & (n - 1);
        }
        return count;
    }
}
