package kk.algoconcepts.sort;

import java.util.Arrays;

/**
 * Exchange sort, aka Sinking Sort.
 * 2 ways: Either move from left to right and take the largest to the rightmost, OR move right to left and take the smallest to the leftmost.
 * Stable V/S unstable sorting algo: When the sequence of equal valued elements are maintained after the sorting, is called stable sorting algo. When order changes, unstable sorting algo.
 */
public class Sorting {
    public static void main(String[] args) {

    }

    // Worst TC: O(N^2) (given arr is opposite sorted); Best TC: O(N) (given arr is required order sorted)
    private static void bubbleSort(int[] arr) {
        boolean swapped = true;
        for (int i = arr.length - 1; i > 0 ; i--) {
            swapped = false;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[j - 1]) {  // This condition decides stable V/S unstable algo condition.
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    // Bubble sort - recursion
    private void bubbleSort(int[] arr, int i, int j) {  // i=arr.length-1, j=[0,i)
        if (i == 0) {
            return;
        } else if (j < i) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubbleSort(arr, i, ++j);
        } else {
            bubbleSort(arr, --i, 0);
        }
    }

    // select an element and put it at its correct index. Performs well on small lists.
    // TC: Worst N^2; Best: N^2
    private static void selectionSorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {  // It is just a counter, elements count limit for j-iterations
            int maxIdx = 0;
            int j;
            for (j = 1; j < arr.length - i; j++) {  // This condition decides stable V/S unstable algo condition.
                maxIdx = arr[j - 1] > arr[j] ? j - 1 : j;
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[j - 1];
            arr[j - 1] = temp;
        }
    }

    // Selection sort - Recursion
    private void selectionSort(int[] arr, int maxEleIdx, int i, int j) {    // i=arr.length-1, j=[0,i), maxEleIdx=anyRandInt
        if (i == 0) {
            return;
        } else if (j < i) {
            maxEleIdx = arr[j] > arr[j + 1] ? j : j + 1;
            selectionSort(arr, maxEleIdx, ++j, i);
        } else {
            // swap the maxEle with the ele at i
            int temp = arr[i];
            arr[i] = arr[maxEleIdx];    // put max where i is pointing
            arr[maxEleIdx] = temp;
            // next iteration call
            selectionSort(arr, maxEleIdx, --i, 0);  // Here, maxEleIdx value could be anything. It doesn't matter because when it is accessed to update its value in above if-block
        }
    }

    //Insertion Sort: Pick an element, and place it on the left of its original place, if possible, such that we do with cards.
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {  // pick an element, and using the below loop compare and then insert at suitable place by shifting places to the right.
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {   // to break the loop when it finds that ele at j is less than ele at j+1.
                // Also, can be achieved by putting second condition in if block inside for loop, and else block as break.
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    // Cyclic Sort: When unordered set has elements range from [1,N] with total elements N, then definitely use cyclic sort. IT SORTS IN O(N) TIME COMPLEXITY.
    // So, at idx i, the value should be i+1 in sorted array. Approach: While iterating, if at idx i the is not i+1, the swap elements then put element on i at i-1 place.
    // Repeat this until at i, there is correct i+1 element. Once correct element is found, move to idx i++. Count this swap and correct placement as 1 unit operation,
    // and halt the operation when there are exactly N operations completed. So total N-1 swaps and 1 correct placement in worst case.
    private static void cyclicSort(int[] arr) {
        arr = new int[] {3,5,2,1,4};
        int i = 0;
        while (i < arr.length) {
            int correctIdx = arr[i] - 1;
            if (arr[i] != arr[correctIdx]) {
                int temp = arr[correctIdx];
                arr[correctIdx] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
        Arrays.toString(arr);
    }

    // merge sort: TC: N*LogN : At evry level N elements are getting merge. Also, depth of recursive call is Log N. So, product is N*LogN
    // Below, we are making new array in every call, and hence not sorting the original array but returning new array with sorted elements.
    // There is another method where in-place sorting happens in merge sort.
    private static int[] mergeSorting1(int[] arr, int start, int end) {  // start=0, end=arr.length-1
        if(start == end) {
            return new int[] {arr[start]};  // single element array
        }

        int mid = start + (end - start) / 2;

        int[] leftArr = mergeSorting1(arr, start, mid);
        int[] rightArr = mergeSorting1(arr, mid + 1, end);

//        return merge(leftArr, rightArr);
        int[] mergedArray = merge1(leftArr, rightArr);

        // We know that the returned array is sorted. Returned array is different from the original array, as it is auxiliary array.
        // We observe that for this recursive call of this function in the call stack, the elements from [start, end] will not be touched, for this recursive call in call stack.
        // It will only be accessed when parent recursive call use it for merging. But here, original array will not be touched, as auxiliary array will be used for merge.
        // According to our solution, original array will not get sorted, but we send the new array which is sorted.

        // To return the original array sorted, we can put the elements sequentially from merged auxiliary array, into original array from index [start, end],
        // But we still have to | must return the auxiliary array, because parent merging methods takes 2 different arrays.
        for (int j = 0; j < mergedArray.length; j++) {
            arr[start + j] = mergedArray[j];
        }
        return mergedArray;
    }
    private static int[] merge1(int[] leftArr, int[] rightArr) {
        int arrLeftStart = 0, arrLeftEnd = leftArr.length - 1, arrRightStart = 0, arrRightEnd = rightArr.length - 1;
        int[] sortedArr = new int[leftArr.length + rightArr.length];
        int idxOfEleToBePutNext = 0;

        while(arrLeftStart <= arrLeftEnd && arrRightStart <= arrRightEnd) {
            if (leftArr[arrLeftStart] <= rightArr[arrRightStart]) {
                sortedArr[idxOfEleToBePutNext++] = leftArr[arrLeftStart++];
            } else {
                sortedArr[idxOfEleToBePutNext++] = rightArr[arrRightStart++];
            }
        }
        while(arrLeftStart <= arrLeftEnd) {
            sortedArr[idxOfEleToBePutNext++] = leftArr[arrLeftStart++];
        }
        while(arrRightStart <= arrRightEnd) {
            sortedArr[idxOfEleToBePutNext++] = rightArr[arrRightStart++];
        }
        return sortedArr;
    }

    // IN-PLACE MERGE SORT:
    private static void mergeSorting2(int[] arr, int start, int end) {
        if (start == end) { // This array of size 1 is already sorted in its own.
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSorting2(arr, start, mid);
        mergeSorting2(arr, mid + 1, end);
        merge2(arr, start, mid, mid + 1, end);
    }

    private static void merge2(int[] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i, j;
        for (i = leftStart, j = rightStart; i <= leftEnd && j <= rightEnd;) {
            if (arr[i] <= arr[j]) {
                i++;
            } else if (arr[i] > arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        if (i <= leftEnd) {
            // Here we'll check if in right array, all the elements are already been compared and swapped(if needed); and there are some extra elements in left which are
            // greater than j's current_pos-1 element, needed to be put after last (j-1)th element. So, copy those elements in temp array, shift right array towards left such that all right are greater than current (i-1)th position.
            // And then put the copied remaining elements from left array towards right of all left shifted elements.
            int[] temp = new int[rightEnd - rightStart + 1];
            // We chose temp arr where first well copy all elements from right sorted array
            int itr = 0;
            while (rightStart <= rightEnd) {
                temp[itr++] = arr[rightStart++];
            }
//            // and now we'll copy the extra elements from i in left array
//            while(i <= leftEnd) {
//                temp[itr++] = arr[i++];
//            }
            // But we can do much better. Now that we have saved elements from right, we can start remaining left array elements from i+rightLength-1 position
            int k = i;
            while(i <= leftEnd) {
                arr[i + (rightEnd - rightStart + 1)] = arr[i];
                i++;
            }
            itr = 0;
            while (itr <= temp.length) {
                arr[k++] = temp[itr++];
            }
        }
//        NOTE: if there are extra elements in right array, then it means they are already at the correct position in the original array, given array in context from [leftStart, rightEnd]

        // Instead of doing all these, since we are anyway making new array, we can try making new array with filling elements from right array, and then remaining from left.
        // And then replace elements from idx i to rightEnd with values in temp array.
    }

    /**
     * QUICK SORT: Where every element will be distinct.
     * There will be recursive approach. So, let array in context have 'low' and 'high' as indicators pointing to first and last ele in array in context.
     * pick a pivot, could be first, last, mid, median, etc. anything. Let 'i' and 'j' be low and high.
     * Since we want ascending sorted array, hence, increase i if ele[i]>ele[pivot], & decrease j such that ele[j]<ele[pivot]
     * Swap ele[i] with ele[j]. Do this until j crosses i, where at this point j will be pointing to actual pivot place, whose value will be < pivot ele.
     * Since we want ascending sorted matrix, we will swap pivot ele with this jth element.
     * We observe that elements on left < pivot ele, and elements on right > pivot.
     * Repeat this again in next recursion call, with left and right array. Anchor condition is when arr of size 1 is given, then return, as it is already sorted.
     */
    private static void quickSort (int[] arr, int start, int end) {     // In-place sorting. TC:Avg:O(NlogN), Worst: O(N^2); SC: O(1). N comparisons done at every level, for logN times.
        if (start >= end) {
            return;
        }
        int pivot = start, i = start, j = end;
        while(i < j) {
            while (arr[i] <= arr[pivot] && i <= end - 1) {  // i <= end - 1 because if this condition holds true then i will be i++, which will be maximum equal to end.
                i++;
            }   // else halt on that i
            while (arr[j] > arr[pivot] && j >= start + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }
}
