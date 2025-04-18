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
        while (start <= end) {  // Assuming array passed will have at least 1 element because start and end can coincide.
            mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) { //If mid is pivot; Arrays min size is 2; first ensuring there is an element after mid && condition. At least 2 elements.
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {    // If mid is smallest element; Arrays minimum size is 3; first ensuring there is an element before mid && condition. At least 2 elements.
                return mid - 1;
            } else if (arr[mid] <= arr[start])  // Because we have put <= instead of just <, ensures that cases of array of size 1 will be handeled here. In case we have put just <, then array of size 1 will be handeled in the below else part.
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

    public static int pivotInNonDuplicatedArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;  // we cannot incorporate this into the last return statement because here this case handles the case of array length of 1 explicitly.
        int start = 0, end = arr.length - 1, mid;
        while (start < end) {   // assuring array of length 2 is into consideration
            mid = start + (end - start) / 2;
            // We assumed there will be at least 2 elements in unsorted manner, for rotated array to be present. Now, we have at least array of size 2, and when we find mid for size 2, then the mid will coincide with start. So, in case of 2 elements, mid will only be compared with the end or mid+1 for cases where elements are > 2.
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (start < mid && arr[mid - 1] < arr[mid]) {    // We have seen worst case where elements could be at least 2 where mid will only be compared with its next element. If this would have been the first case check, then code would have been broken because mid(0 in case of 2 elements) would be compared with mid-1, ie, idx -1, giving IndexOutOfBoundException
                return mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {   // If we are not comparing mid element with start element then this might lead us to IndexOutOfBoundException.
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;  // Or we can return arr.length-1 which signifies the largest element in the array which is at last. But this array will not be the rotated array. It could be sorted array of any size or array of size 0 as well.
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
            // Now, we cannot put rest 2 cases because as per the given example above this method, because element at mid, start and end are equals. Both of those 2 examples will be satisfied by either of the last 2 conditions.
            // There is no exclusive case where control will move [assuming all cases are in if conditions, and not in if-else-if condition, so it'll end up entering last both if cases].
            // We cannot decide at which part the pivot lies, left or right. So, it looks like a failed logic at this scenario.
            // The above two cases works if in First case, elements at mid and mid+1 are different; Second, elements at mid amd mid-1 are different. But here in repetitive element case, both can be same.
            // Therefore, we are now having 3 cases to deal with. First where mid start and end are equal to each other. Second, where mid and start are equal to each other but not with end.
            // Third, where mid and end are equal to each other but not equal to start.
            // So, to overcome this and to satisfy above two scenario, we can ignore duplicate elements which are equal to mid-element and present at start and|or end.
            // Another note: In these cases, we first try to find the staright-forward answers(above 2 cases). Later we try to ignore the duplicates. But since there is a possibility that duplicates might be a pivot, hence we do a little check over them before ignoring them.
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // Also, there might be case where element at start or end that we are skipping, might be the pivot.
                if(arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // This case will be executed as there will be the case where and element before end will be greater than end, provided start == end holds true
                // We are not considering the end element as the pivot because we haven't considered at any time that array in context will be sorted array, with pivot at the end.
                // If pivot will be at end in the original array, then this method will give -1 as return value. Otherwise, in successive iterations, there won't be case where pivot will be at the end of array in context.
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // if left side of array sorted, so we will find pivot in right side
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // Below 2 are to find target in rotated array, without first finding the pivot
    static int targetInNonDuplicatedRoatated(int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (arr[mid] == target) {
                return mid;
            }
            // Next approach would be, to find the side where target could exist. Since it is rotated array, we cannot simply check mid with its neighbours to predict the sorted side of the array. So we compare mid with start and end elements, and then we'll 2 paths. First, to check if target exists in sorted part and then proceed with it. Else, proceed with the unsorted part.
            else if (mid < end && arr[mid] < arr[end]) {   // Same logic as above, to first check mid with end, and not with start. There are no duplicates AND array in context will not have 1 element at this else-if part(it'll be handled in first if case), hence I didn't assume the element at mid and end could be equal.
                // Inside here, second half is sorted half. Now we check if target lies within this sorted half. If yes, we continue with sorted search space, else with unsorted search space.
                if (arr[mid] < target && target <= arr[end]) {  // Here, we know that at this point target element cannot be equal to mid element, but might be equal to end element.
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // Inside here, first half is sorted. So we check if target lies in sorted half. If yes then continue with sorted search space, else continue with unsorted search space.
                if (arr[start] <= target && target < arr[mid]) {    // at this point, target will not be equal to mid element but might be equal to start element.
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    static boolean ifTargetInDuplicatedRotated(int[] arr, int target) {     // It is NOT possible from binary search to directly find the index of a target in a rotated duplicated array. But we can check if it exists or not.
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (arr[mid] == target) {
                return true;
            }
            // Now, there could be case where {10, 10, 10, 10, 1, 2, 10} mid and end are equal and target is 1, and when we go to find the sorted half of and array by first comparing mid element with end element, and then find the potential side in which target lies, we could end up selecting wrong half into consideration for further iterations. Because, {10, 1, 2, 10, 10, 10, 10, 10} could be the case also.
            // So, to decide which half is sorted array, there has to be the case where below condition should hold false.
            else if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                if (arr[start] == target) {
                    return true;
                }
                start++;

                if (arr[end] == target) {
                    return true;
                }
                end--;
            } // Now that we have case where we can easily identify which part is sorted, we will perform that below:
            else if (arr[mid] < arr[end] || (arr[mid] == arr[end] && arr[start] > arr[mid])) {
                // Now we are in a sorted space which is second half. Check where target lies, in which half.
                if (arr[mid] < target && target <= arr[end]) {  // check if target is in sorted part
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
