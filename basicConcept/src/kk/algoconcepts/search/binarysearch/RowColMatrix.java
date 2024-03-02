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
        System.out.println(Arrays.toString(search2(arr, 6)));   // log(row) + log(col)
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
        if (matrix[rStart + 1][cMid] == target) {
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
        if (target <= matrix[rStart][cMid - 1]) {
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
