package kk.algoconcepts.search.linearsearch;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {23, 45, 1, 2, 8444, 19, -3, 1633333, -11, 28};
        int target = 19;
        System.out.println(linearSearch(nums, target));

        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {18, 12}
        };

        target = 34;
        System.out.println(searchIn2D(arr, target));

        System.out.println(elementCountEvenDigits(nums));
    }

    // search in the array: return the index if found, else return -1
    static int linearSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        return -1;
    }

    /*
    We can make search logic for finding character in string; for finding target between index ranges; can return boolean as well; can search in 2D Arrays; can find max|min in arr;
     */
    static String searchIn2D(int[][] arr, int target) {
        if (arr == null || arr.length == 0) { return -1 + ", " + -1; }
        for (int[] ar : arr) {
//            if (ar == null) { return -1 + ", " + -1; }    // What if element is present in upcoming rows. Hence, writing this line is wrong.
        }

        int rowCount = -1;
        for (int[] row : arr) {
            rowCount++;
            for (int index = 0; index < row.length; index++) {
                int element = row[index];
                if (element == target) { return rowCount + ", " + index; }
            }
        }
        return -1 + ", " + -1;
    }
//Count of numbers having even numbers of digits
    static int elementCountEvenDigits(int[] arr) {
        int count = 0;
        for (int element : arr) {
            if (element < 0) { element*= -1; }
            if (((int)(Math.floor(Math.log10(element)) + 1) & 1) == 0) {
                count++;
            }
        }
        return count;
    }
}
