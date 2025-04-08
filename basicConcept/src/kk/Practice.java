package kk;

public class Practice {
    public static void main (String[] args) {
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
        System.out.println(searchMatrix(matrix, 3));
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
}