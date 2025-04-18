package kk;

public class Practice {
    public static void main (String[] args) {
        int[] a = {}, b = {6,7,9};
        System.out.println(kthElement(a, b, 4));

        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
                {-8,-8,-7,-6,-5,-5,-5},
                {-2,-1,1,1,3,5,7},
                {10,10,12,14,16,17,19},
                {20,21,21,23,25,25,27},
                {28,28,29,31,32,33,34},
                {35,37,39,41,41,42,42}
        };
//        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;

        if (rows == 1) {
            return binarySearch(matrix[0], 0, cols - 1, target);
        }

        int rStart = 0, rEnd = rows - 1, rMid, cMid = (cols - 1) >> 1;
        while (rStart < (rEnd - 1)) {
            rMid = rStart + ((rEnd - rStart) >> 1);
            if (rMid == target) {
                return true;
            } else if (matrix[rMid][cMid] < target) {
                rEnd = rMid;
            } else {
                rStart = rMid;
            }
        }

        if (matrix[rStart][cMid] == target) {
            return true;
        } else if (matrix[rEnd][cMid] == target) {
            return true;
        } else if (target < matrix[rStart][cMid]) {
            return binarySearch(matrix[rStart], 0, cMid - 1, target);
        } else if (target > matrix[rStart][cMid] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix[rStart], cMid + 1, cols - 1, target);
        } else if (target < matrix[rEnd][cMid]) {
            return binarySearch(matrix[rEnd], 0, cMid - 1, target);
        } else {
            return binarySearch(matrix[rEnd], cMid + 1, cols - 1, target);
        }
    }

    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        int mid;
        while (start < end) {
            mid = start +((end - start) >> 1);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static int kthElement(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) {  // To perform the binary search on the smaller search space, ie, on nums1
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int totEle = nums1.length + nums2.length;
        int start = 0, end, mid, median;
        median = k;
        end = Math.min(median, nums1.length);   // There might be case where mid will be beyond the max idx of nums1 array. So, assuring that mid does not exceed the index bound, we did this.
        int l1, l2, r1, r2;
        while (start <= end) {  // start = 0, and end = median. So, we have a range to options to include the elements from left of the nums1 in count [start, end]
            mid = start + ((end - start) >> 1); // this much number of elements form first array from left will be considered, and rest (end - mid) will be considered from the nums2, that too from the left.
            // mid is the count of elements. So, index will be mid-1. Now, there will be the case where idx obtained from mid might be out of bound of the arrays. In that case, we strategically took l1|2 and r1|2 values.
            l1 = (mid - 1) >= 0 && (mid - 1) < nums1.length ? nums1[mid - 1] : Integer.MIN_VALUE;
            r1 = ((mid - 1) + 1) >= 0 && ((mid - 1) + 1) < nums1.length ? nums1[(mid - 1) + 1] : Integer.MAX_VALUE;
            l2 = ((median - mid) - 1) >= 0 && ((median - mid) - 1) < nums2.length ? nums2[(median - mid) - 1] : Integer.MIN_VALUE;
            r2 = (((median - mid) - 1) + 1) >= 0 && (((median - mid) - 1) + 1) < nums2.length ? nums2[((median - mid) - 1) + 1] : Integer.MAX_VALUE;
            // nums1[l1] <= nums1[r1] will always hold true. Also, nums2[l2] <= nums2[r2] will always hold true.
            if (l1 <= r2 && l2 <= r1) {
                return (Math.max(l1, l2));
            }
            if (l1 > r2) {
                end = mid - 1;
            } else if (l2 > r1) {
                start = mid + 1;
            }
        }
        return -1;
    }
}