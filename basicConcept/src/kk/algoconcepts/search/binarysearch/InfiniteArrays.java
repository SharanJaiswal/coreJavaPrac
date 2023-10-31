package kk.algoconcepts.search.binarysearch;

import java.util.Arrays;

// Infinite integer array is given in non-decreasing order, and may have repetitive elements. FInd the index of the target in such array. We cannot use arrayObj.length, or end
// O(log N) <= 2 * (log N)
public class InfiniteArrays {
    public static void main(String[] args) {
        int arr[] = {23, 24, 25, 999, 999, 999, 999 ,999, 999, 999, 1000};
        int target = 989;
        System.out.println(Arrays.toString(InfiniteArrays.pickArrayForBinarySearch(arr, target)));
    }

    /*
    To select array where element can appear can be achieved by 2 ways. Either we iteratively pick window of fixed size and compare target from extremes values, or
    We can pick window of exponentially increasing size, and compare target with extremes at the window.
    At comparing on extremes in potential sub array, if we find target match, we can include elements further that extreme that include all occurrences of that target at extreme, exponentially.
     */
    static int[] pickArrayForBinarySearch(int[] arr, int target) {
        int start = -1, end = -1, windowSalt = 0, windowSize;
        boolean subArrayCouldNotBeFound = false;    // When it is evident that target could not be in any possible window
        boolean subArrFound = false;

        while (!subArrayCouldNotBeFound && !subArrFound) {
            windowSize = (int)(Math.pow(2, windowSalt++));
            start = end + 1;
            end = start + windowSize - 1;

            // Below part won't be there if there is infinite number of elements
            if (end >= arr.length) {
                if (start < arr.length) { end = arr.length - 1; }   // If only end iterator is out of bound of original array  but start iterator is within original array bound.
                else { subArrayCouldNotBeFound = true; break; } // because we didn't find any window that could have target into it.
            }

            // Now we know that start pointer is found based on end pointer. So, if at end, target==arr[end] then we  must expand window at right using end pointer.
            // In next iteration of this while loop start will be end+1, which might again point target's value on arr. So, extending window at left using start is redundant,
            // because we have already increased the window at right in previous iteration.
            // In fact, if we take care of expanding at right, there will be no scenario where we had to expand window using start towards left.
            // So, code to expand window towards right exponentially is below
            while (arr[end] == target) {
                windowSize = (int)(Math.pow(2, windowSalt++));
                end += windowSize;
                end = end >= arr.length ? arr.length - 1 : end;

                if(end == arr.length - 1) { break; }
            }
            if (arr[end] >= target) {
                subArrFound = true;
            }
        }

        return subArrayCouldNotBeFound ? new int[] {-1, -1} : InfiniteArrays.binarySearch(arr, target, start, end);
    }
    static int[] binarySearch(int[] arr, int target, int start, int end) {
        int s = start, e = end, mid, a = -1, b = -1;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                a = (a == -1 || mid < a) ? mid : a;
                e = mid - 1;
            } else if (arr[mid] > target) { e = mid - 1; }
            else { s = mid + 1; }
        }
        s = start;
        e = end;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                b = (b == -1 || mid > b) ? mid : b;
                s = mid + 1;
            } else if (arr[mid] > target) { e = mid - 1; }
            else { s = mid + 1; }
        }
        return new int[] {a, b};
    }
}
