package kk.arraylistAndGenerics;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            int inp = input.nextInt();
            if (inp > 0) arr.add(inp);
            else break;
        }
        reverseArrayList(arr);
        System.out.println(arr);
    }

    // Similarly, we can use this below logic of ArrayList for reversing an Array.
    static void reverseArrayList(ArrayList<Integer> arr) {
        if (arr == null || arr.size() <= 1) { /* DO NOTHING. For handling the swapping. */ }
        else {
            for (int i = 0, j = arr.size() - 1; i < j; i++, j--) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
    }
}
