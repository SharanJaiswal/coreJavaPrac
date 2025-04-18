package kk.algoconcepts.search.binarysearch;

public class ExtraQuestions {
    public static void main(String[] args) {

    }

    public static long floorSqrt(long n) {  // largest integer whose square is <= given n.
        long start = 0L, end = n, mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (mid * mid <= n) {   // Even if the value is equal, there is possibility of another answer(well not logically). But when we skip the answer, what happens is that at the end of iteration, "end" will be one less than "start"
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
