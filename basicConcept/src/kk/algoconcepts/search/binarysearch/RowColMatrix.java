package kk.algoconcepts.search.binarysearch;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        System.out.println(Arrays.toString(search(arr, 49)));

        arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(search2(arr, 1)));   // log(row) + log(col)
    }

    /*
    When arrays is having fixed number of rows and columns.
    In array, row and columns are sorted individually; not sorted in row-order or column order.
     */
    static int[]  search(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;

        while (r < matrix.length && c>= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            } else if (matrix[r][c] < target) {
                r ++;
            } else {
                c--;
            }
        }
        return new int[] {-1, -1};
    }

    // Array is sorted in row-order
    static int[] search2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;    // be cautious, because matrix maybe empty

        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        /**
         * Now, below condition in the while loop will ensure that rStart and rEnd will be consecutive to each other, after the end of the loop.
         * Later we see that we have performed linear search on the middle column only to see the occurrence of the target.
         * Later we see that we have performed binary search on sub-array left of first element of the mid-col; then binary-search on sub-array of right of the first element of mid-col; and same for second element of the mid-col.
         * If, rStart is updated during the process in while loop, then there would have been no need to compare target with first element of the mid-col, also no need to perform binary search on the sub-array to the left of first element of the mid-col
         * If, rEnd is updated during the process in while loop, then there would have been no need to compare target with second|last element of the mid-col, also no need to perform binary search on the sub-array to the right of second|last element of the mid-col
         * We anyway are still performing these 4 operations because there will be cases where rStart or rEnd might not be updated. Such cases would be either when matrix is having only 2 rows. In that case while loop won't even run, and the possibility of target on these 4 cases which could be skipped otherwise, can happen.
         * Similarly, if target is on either first row or last row. In such cases, tagret could be in the left sub-array of the first element of the mid-col; or could be in the right sub-array of the last element of the mid-col, of the original matrix.
         */

        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) {   // while this is true, it will have more than 2 rows
            int mid = rStart + (rEnd - rStart) / 2;

            if (matrix[mid][cMid] == target) {
                return new int[] {mid, cMid};
            }
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // now we have 2 rows. Check whether the target is in the col of 3 rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[] {rStart + 1, cMid};
        }

        // Search in 1st half sorted array
        if (target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }

        // Search in 2nd half sorted array
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }

        // Search in 3rd half sorted array
        if (target <= matrix[rEnd][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        }

        // Search in 4th half sorted array
        else {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }

    // simple binary search
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if(matrix[row][mid] == target) {
                return new int[] {row, mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
