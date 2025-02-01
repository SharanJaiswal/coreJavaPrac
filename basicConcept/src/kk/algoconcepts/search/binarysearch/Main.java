package kk.algoconcepts.search.binarysearch;

/**
 * If there is a sequence of numbers where numbers are either increasing or decreasing,
 * If there is continuous or periodic set of numbers between some range,
 * If sub-problem satisfies above 2 conditions, etc.,
 */
public class Main {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr = {9,8,7,6,5,4,3,2,1};
        // For Order agnostic binary search in an array
        int ans = (arr[0] - arr[arr.length - 1] < 0) ? Main.binarySearchAscending(arr, 8) : Main.binarySearchDescending(arr, 8);
        System.out.println(ans);
    }

    static int binarySearchAscending (int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;    // because start+end could be out of range of int data type
            if (target == arr[mid]) { return mid; }
            else if (target < arr[mid]) { end = mid - 1; }
            else { start = mid + 1; }
        }
        return -1;
    }

    static int binarySearchDescending (int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if (target == arr[mid]) { return mid; }
            else if (target < arr[mid]) { start = mid + 1; }
            else { end = mid - 1; }
        }
        return -1;
    }
}
