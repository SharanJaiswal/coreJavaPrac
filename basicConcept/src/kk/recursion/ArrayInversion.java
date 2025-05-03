package kk.recursion;

/**
 * Count the number of pairs that where first of pair is greater than last of pair. Ordering of pared sequence should not be changed, as given in an array.
 */
public class ArrayInversion {
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int invArrCnt = 0;
        int mid = start + (end - start) / 2;
        invArrCnt += mergeSort(arr, start, mid);;
        invArrCnt += mergeSort(arr, mid + 1, end);
        invArrCnt += merge(arr, start, mid, mid + 1, end);
        return invArrCnt;
    }

    private static int merge(int[] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int invArrCnt = 0;
        int[] tempArr = new int[rightEnd - leftStart + 1];
        int i = leftStart, j = rightStart, k = 0;
        while(i <= leftEnd && j<= rightEnd) {
            if(arr[i] <= arr[j]) {
                tempArr[k++] = arr[i];
                i++;
            } else {    // place where right is smaller. So, in the left arr, elements from i to leftEnd will be greater than jth ele.
                invArrCnt += leftEnd - i + 1;
                tempArr[k++] = arr[j];
                j++;
            }
        }
        while(i <= leftEnd) {
            tempArr[k++] = arr[i++];
        }
        while(j <= rightEnd) {
            tempArr[k++] = arr[j++];
        }
        for(i = leftStart, k = 0; i <= rightEnd; i++, k++) {
            arr[i] = tempArr[k];
        }
        return invArrCnt;
    }
}
