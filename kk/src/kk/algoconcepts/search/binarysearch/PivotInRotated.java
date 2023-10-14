package kk.algoconcepts.search.binarysearch;

public class PivotInRotated {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,3};
        int target = 6, start = 0, end = arr.length - 1;
        int pivot = PivotInRotated.findThePivot(arr);
        System.out.println(pivot);
        if (target == -1) { // call binary search for already sorted non-rotated array of size >= 1.
            // call binary search with start and end
        } else if (target == arr[pivot]) {
            System.out.println(pivot);
            // call binary search with start and end
        } else if (target >= arr[0]) {  // Using >= instead of > because target could be start element in rotated array.
            end = pivot - 1;
            // call binary search with start and end
        } else {
            start = pivot + 1;
            // call binary search with start and end
        }
    }

    static int findThePivot(int[] arr) {
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {  // Solution is for array having non-duplicate elements
            mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) { // first condition before && ensuring there is an element after mid. At least 2 elements.
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {    // first condition before && ensuring there is an element before mid. At least 2 elements.
                return mid - 1;
            } else if (arr[mid] <= arr[start]) {    // we used <= and not < because this can handle array of size 1 where mid and start CAN point to same first element.
                end = mid - 1;
            } else {    // if (arr[mid] > arr[start]    // where start to mid is already sorted
                start = mid + 1;    // There is a possibility where mid is pivot. So, making start as element next to pivot ie, smallest element might skip pivot from array in concern.
                // Hence, that case has already been covered
            }
        }
        return -1;  // When array is sorted or of size 1;
        // If pivot is found, then there is sure-shot 2 ascending array
    }
}
