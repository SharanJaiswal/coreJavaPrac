package kk.algoconcepts.search.binarysearch;

public class PivotInRotated {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,3};
        int target = 6, start = 0, end = arr.length - 1;
        int pivot = PivotInRotated.findThePivot_nonDuplicated(arr);
        System.out.println(pivot);
        if (pivot == -1) {
            System.out.println("Array is null or of size zero.");
        } else if (pivot == -2) { // call binary search for already sorted non-rotated array of size >= 1.
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

    /**
     * If array is rotated, there must be at least 2 elements, and it is assumed that it is not sorted.
     * Sorted arrays are not considered rotated.
     * There are 2 cases, where array in context can be of size 1 or >1.
     * If it is of 1, then mid==end holds true.
     * If it is >1, then mid will always be less than end.
     */
    static int findThePivot_nonDuplicated(int[] arr) {
        if (null == arr || arr.length == 0) {   // If we don't want to pass array of size 1 into below while loop, then update while condition as (start < end) and here (arr.length<=1)
            return -1;
        }
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {  // Assuming array passed will have at least 1 element.
            mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) { //If mid is pivot; Arrays min size is 2; first ensuring there is an element after mid && condition. At least 2 elements.
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {    // If mid is smallest element; Arrays minimum size is 3; first ensuring there is an element before mid && condition. At least 2 elements.
                return mid - 1;
            } else if (arr[mid] <= arr[start])
            // We are not considering the end element as the pivot because we haven't considered at any time that array in context will be sorted array, with pivot at the end.
            // If pivot will be at end in the original array, then this method will give -1 as return value. Otherwise, in successive iterations, there won't be case where pivot will be at the end of array in context.
            {    // we used <= and not < because this can handle array of size 1|2 where mid and start CAN point to same start element.
                end = mid - 1;
            } else {    // if (arr[mid] > arr[start]    // where start to mid is already sorted
                start = mid + 1;    // There is a possibility where mid is pivot. So, assuming there is an element next to mid and making start as element next to pivot ie,
                // smallest element might skip pivot from array in concern. But, that case has already been covered in case 1
            }
        }
        return -2;  // When array is sorted or of size 1, or when array is not rotated at all. We could actually send "array.length - 1" here instead of -1.
        // If pivot is found, then there is sure-shot 2 ascending array
    }

    // For sorted arrays containing the duplicated elements: [2, 2, 9, 10, 10, 2, 2, 2, 2, 2, 2, 2, 2, 2]
    // {10,10(p),1,2,10,10(m),10,10,10,10,10,10}        OR      {10,10,10,10,10,10(m),10(p),10,1,2,10,10}
    static int findThePivot_Duplicated(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return -1;
        }
        int start = 0, end = arr.length, mid, potentialIdx=-1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (start < mid && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // Now, we cannot put rest 2 cases because as per the given example above this method, because element at mid, start and end are equals. Those will be satisfied by both the 2 conditions.
            // There is no exclusive case where control will move [assuming all cases are in if conditions, and not in if-else-if condition, so it'll end up entering last both if cases].
            // We cannot decide at which part the pivot lies, left or right. So, it looks like a failed logic at this scenario.
            // The above two cases works if in First case, elements at mid and mid+1 are different; Second, elements at mid amd mid-1 are different. But here in repetitive element case, both can be same.
            // Therefore, we are now having 3 cases to deal with. First where mid start and end are equal to each other. Second, where mid and start are equal to each other but not with end.
            // Third, where mid and end are equal to each other but not equal to start.
            // So, to overcome this and to satisfy above two scenario, we can ignore duplicate elements which are equal to mid-element and present at start and|or end.
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // Also, there might be case where element at start or end that we are skipping, might be the pivot.
                if(arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // We are not considering the end element as the pivot because we haven't considered at any time that array in context will be sorted array, with pivot at the end.
                // If pivot will be at end in the original array, then this method will give -1 as return value. Otherwise, in successive iterations, there won't be case where pivot will be at the end of array in context.
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // if left side of array sorted, so we will find pivot in right side
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid - 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
