package kk.recursion;

import java.util.ArrayList;

public class BasicMore {
    public static void main(String[] args) {

    }

    // Sum of unique combinations of elements, where an element at max can be picked only once. Sort the sum arr result
    // For N elements of arr, there are 2^N subsets. Also, each call has sorting XlogX, where X=2^N. Therefore, total TC: (2^n + (2^N)log(2^N)) `~~= ((2^N)log(2^N)) {MAX}
    // SC: 2^N
    private static void subsetSum(int[] candidates, int currentIdx, int sum, ArrayList<Integer> sumArr) {
        if (currentIdx == candidates.length) {
            sumArr.add(sum);
            return;
        }
        subsetSum(candidates, currentIdx + 1, sum + candidates[currentIdx], sumArr);
        subsetSum(candidates, currentIdx + 1, sum, sumArr);
        sumArr.sort(null);
    }
 }
