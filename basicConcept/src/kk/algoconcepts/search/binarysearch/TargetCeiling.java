package kk.algoconcepts.search.binarysearch;
// to find the first smallest element's index where that element is >= target in ascending sorted array
// It is not required that target must be present in the array. There could be cases where target is not present in the array, still we can get the answer.
// eg, if target < arr[0], then answer is arr[0]; if arr[0]<target<arr[max_idx], where target element is not in arr, then answer will surely be one element among all array elements;
// For case where target> arr[max_idx], answer is not possible
public class TargetCeiling {
    public static void main(String[] args) {
        int[] arr = null;
    }
// Solution covers edge cases of array pointing null, target will not satisfy at all in arr (consecutively search in right|left sub array and will break out of while loop, returning -1)
    static int findCeilElement(int[] arr, int target) {
        int targetIdx = -1;
        if (arr == null || arr.length == 0) { return targetIdx; }
        int start = 0, end = arr.length, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) { return mid; }
            else if (target < arr[mid]) {
                // {1,3,5,7}, T=2, ar[mid]=3, although we will look further in left subarray but ar[mid] could be the answer if condition not fall in subarray
                // because we are finding ceil, hence mid is potential index where condition satisfies of question
// we are looking in sub array because actual element could be < arr[mid] of this IF condition, but also could be > target. If later condition is not satisfied, ans is element of this mid
                targetIdx = mid;
                end = mid - 1;
                // When suppose in case the left sub array does not have the required answer, then targetIdx is the required answer; provided ans is in the array
            // In cases, when we move to left subarray to find potential replacement of targetIDX found, in that left sub array, iteratively we will jump to consecutive right subarray.
            // We'll move to right until we consider array in context of size 1, which is just the element left of the found potential element index. Here, we will enter below else part.
            // This will increase start by 1 which will eventually make end=start-1, ie, start will be ahead of end, which will break while loop. Ans will be earlier found potential idx
            } else { start = mid + 1; }
            // when loop breaks, and we are ensured that condition will satisfy in array, we can send this start. As at this loop breaking point start will hold same index value as potential index
        }
        return targetIdx;
    }

    /*
FOR FLOOR:
If we need to find the largest floor of target, then when condition hits where target>arr[mid], we take this mid as potential index, and search in subarray right of mid.
If condition won't be satisfying in right subarray, then we will be selecting leftmost subarray of this right subarray mentioned above in consecutive iteration, until loop breaks.
Hence, will return the potential index.
// when loop breaks, and we are ensured that condition will satisfy in array, we can send end. As at this loop breaking point end will hold same index value as potential index
 */
    public static int findFloorElement(int[] arr, int target) {
        int targetIndex = -1;
        if (arr == null || arr.length == 0) {
            return targetIndex;
        } else {
            int start = 0, end = arr.length - 1, mid;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (target > arr[mid]) {
                    targetIndex = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return targetIndex;
    }

}
