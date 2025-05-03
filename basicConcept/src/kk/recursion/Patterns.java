package kk.recursion;

import java.util.ArrayList;

public class Patterns {
    public static void main(String[] args) {

    }

    /**
     * We need to know prior to call recursive function, even for the very first time, all the rows and cols
     */

//    * * * *
//    * * *
//    * *
//    *
    private void pattern1(int rows, int cols) { // total rows == 4, cols = [0,rows). Approach: row loop will run till its > 0, Col continue to run to its value of row (0-row)
        // Idea of recursive call is, take one row, print each star recursively of that row only if col < row. When col==row, then move to next line, reset col to 0, dec row by 1. Do this only when row > 0
        if (rows == 0) {
            return;
        } else if (cols < rows) {
            System.out.println("* ");
            pattern1(rows, ++cols);
        } else {
            System.out.println();
            cols = 0;
            pattern1(--rows, cols);
        }
    }

    // Upside down of pattern 1
    private void pattern2(int rows, int cols) { // r=4,c=0
        if (rows == 0) {
            return;
        } else if (cols < rows) {
            pattern2(rows, ++cols);
            System.out.println("* ");
        } else {
            cols = 0;
            pattern2(--rows, cols);
            System.out.println();
        }
    }

    // Bubble sort
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

    // Selection sort
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
}
