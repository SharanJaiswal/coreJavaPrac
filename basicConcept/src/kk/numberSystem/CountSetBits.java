package kk.numberSystem;
/**
 * THIS IS ONLY TRUE FOR NON-NEGATIVE INTEGERS. iF NEGATIVE INTEGERS ARE PRESENT IN SCOPE, BETTER CONVERT NEGATIVE TO POSITIVE AND THEN CHECK IF IT IS NOT REQUIRED TO CHECK ITS 2COMPLIMENT
 * One way could be brute force approach of O(B) time complexity where B is the number of bits in the binary representation of the number,
 * where in every iteration, counter is increased on every set bit. if(N & (1<<i)) for i ranging from 0 to 31 for a 32-bit binary representation of a number.
 * Better brute force will be considering only decimal representation where in every iteration, before right shifting the N it'll be checked if the N if odd then increase the counter. O(log2(N))
 * Best approach is below where worst case will be O(B), in actual case, loop will run only that number time which is equal to total count of set bits.
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

    /**
     * FEW MORE QUESTIONS
     */
    // Minimum flips in bits required to convert a number from A to B
    private static void minBitsFlipped(int a, int b) {
        System.out.println(setBitsCount(a^b));
        // Approach: Minimum bits required to flip to convert is total count of bits which are different. First we can find binary representation of a number that contain only different bits.
        // It can be found out by XORing 'a' and 'b'. Once this is found out, All we need to do is to find the number of set bits, where each set represents the place of difference of bits in binary representation of 'a' and 'b'.
    }
}
