package kk.arraylistAndGenerics;
/*
Arrays are fixed sized, ie, we need to mention the number of elements that it holds, its length. For dynamic size arrays, we use ArrayList
 */
import java.util.Arrays;

public class ArrayDS {
    public static void main(String[] args) {
        int[] arr = null;
//        System.out.println(arr.length); // will give error because arr reference variable is not pointing to any array. Hence, size of null cannot be found. It is absurd, causes NPE

        // syntax
        // datatype[] reference_var = new datatype[size];   // reference_var is pointing to memory having arrays of LHS datatype
        int[] rollNos1 = new int[5];
        int[] rollNos2 = {23,24,25,26,27};
        // LHS datatype ensures what type of data will be stored in the array, all the elements in array will of this LHS datatype.

        // Breaking down the step :
        int[] rollNos3; // declaration of array. rollNos3 is getting defined in the stack memory. Happens at compile time.
        rollNos3 = new int[3];  // object is being created in heap memory. Happens at runtime. Dynamic memory allocation.
        System.out.println(rollNos3[1]);    // default value of integer element of an array is zero
        rollNos3[1] = 45;   // makes rollNos3 [0, 45, 0]

        for (int num : rollNos3) {
            num = 34;
        }
        for (int num : rollNos3) {
            System.out.print(num + " ");
        }
        /*
        Above didn't work because, we know int num = arr[i]; where arr[i] is of type int which is separate ref_var from int num.
        num "copies" the value of arr[i] into it. Since arr[i] is just of primitive data type, hence changing value of num does not affect the value of arr[i].
        However, if arr[i] had been of complex data type then it had hold the reference of the object instantiated. In that case, num would also be referring the same memory reference.
        Hence, change in value of num would mean it's not changing the object which is referred by arr[i], but would change the object referred by num.
        So, in either of case, assigning value using for each loop doesn't work. Example with complex object type is given below.
         */
        String[] strarr = new String[] {"Sharan", "Jaiswal"};
        for (String strele : strarr) {
            strele = "Saint";
        }
        System.out.println(Arrays.toString(strarr));
        // Hence in both the cases, to change the element value, do is like: arr[i] = new_value; Arrays are mutable in java.


        /*
        [
          [] -> [ , , ...]
          [] -> [ , , ...]
          [] -> [ , , ...]
        ]
         */
        // Adding number of rows is mandatory if we are initializing it. Adding number of columns is optional, but we know by how much column to initialize each and all row
        int[][] multArr1 = new int[3][];
        int[][] multArr2 = {
                {1,2,3},    // In C/C++, row-order or column order arrangement is done to store all the elements values of 2D array in continuous manner, logically in memory.
                {4,5,6},    // In Java, it is stored in heap memory, [][](stack) -> [row1, row2, row3, ...](heap)
                {7,8,9,0}     // row1 -> [1,2,3](heap); row2 -> [4,5,6](heap); row3 -> [7,8,9,0](heap); . . . . . .(heap)   // Individual row size may vary if we don't give 'j' in [i][j]
        };

        for (int row = 0; row < multArr2.length; row++) {
            for (int col = 0; col < multArr2[row].length; col++) {
                System.out.print(multArr2[row][col]);
            }
            System.out.println();
        }   // Another way is below
        for (int row = 0; row < multArr2.length; row++) {   // also can be done using foreach loop
            System.out.println(Arrays.toString(multArr2[row]));
        }
        System.out.println(Arrays.toString(multArr2));  // [][] Array stores reference of [] Arrays
    }
}