package kk.numberSystem;

import java.util.ArrayList;

/**
 * This is to find all the subsets of a given set. Now, total possible subsets for a given set of N elements is 2^N. Lets take n=3 as eg. So 8 subsets are possible.
 * Now, binary representation of 2^N is 1 followed by N number of zeros which will be the smallest N+1 digit of binary number. So, number (2^N)-1 will be largest N-1 digit binary number.
 * So, binary representation of all the numbers from 0 to (2^N)-1 will have all possible permutation of 0s and 1s for binary string of length N.
 * Since, each number between (2^N)-1 and 0 will have N bits and given set has also N-bits, so picking one number at a time from binary representation of numbers between (2^N)-1 and 0
 * can be used to represent each subset where position of set bit will be used to consider that positioned index element from the given set.
 */
public class PowerSet {
    public static void main(String[] args) {
        powerSet(new int[]{1,2,3});
    }

    private static void powerSet(int[] superSet) {  // TC: (N*(2^N)) where N is number of elements in superset
        for (int i = 0; i < (1 << superSet.length); i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            int count = 0;
            while (count < superSet.length) {
                if ((i & (1 << count)) != 0) {
                    subset.add(superSet[count]);
                }
                count++;
            }
            System.out.println(subset);
        }
    }
}
