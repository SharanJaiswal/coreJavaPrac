package kk.arraylistAndGenerics;
/*
Dynamic size is not actually true. Internally, the size is fixed, but keeps on changing until certain threshold is reached. When element count threshold hits,
new ArrayList is created, elements from old arraylist are copied to new one, new arraylist reference replaces the old arraylist, old arraylist gets deleted.
All this happens seamlessly.
 */

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        // syntax: LHS should have the datatype of elements inside diamond operator. RHS can also have it but its redundant to have same datatype there in <> in RHS
        // () calls constructor in RHS can have initialCapacity of ArrayList.
        // In Java, <> cannot have primitive data types inside it.
        // Therefore, to make generics compatible with primitive data types, there is an autoboxing of primitives, makes them derived type of Java Object, called wrapper objects.
        ArrayList<Integer> arrayList = new ArrayList<>();

        ArrayList<Integer> arr1 = new ArrayList<>(5);
        arr1.add(234);
        arr1.add(12);
        arr1.add(546);
        arr1.add(38);
        arr1.add(90);

        System.out.println(arr1.contains(10));
        System.out.println(arr1.contains(234));
        System.out.println(arr1);
        arr1.set(2,34567);
        System.out.println(arr1);
        arr1.remove(1);
        System.out.println(arr1.remove(new Integer(90)));
        System.out.println(arr1);
        arr1.add(1, 407);
        System.out.println(arr1);
        
        // Input in arrayList
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            arr1.add(scanner.nextInt());
        }
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(arr1.get(i));    // syntax like arr1[idx] will not work here
        }


        // Multidimensional ArrayList
        ArrayList<ArrayList<Integer>> multArrList = new ArrayList<>();
        // Now multArrList points to single dimension array currently. So we need to initialize the elements of it, each as an individual array, ie,
        // we will initialize rows first, later define them
        for (int i = 0; i < 3; i++) {
            multArrList.add(i, new ArrayList<>());
        }
        // Now define the elements in each rows
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {   // Making 3 x 2 dimension arrayList. Size of each can also be dynamic.
                multArrList.get(i).add(scanner.nextInt());
            }
        }
        System.out.println(multArrList);

        // Also, look below methods:
//        arr1.retainAll(any other collection);   // arr1 will have only those elements which will be common to arr1 and collection item passed
//        arr1.replaceAll();  // takes UnaryOperator type instance which is basically a lambda which takes one element at a time as an input from arr1,
        // and transforms and returns an element of type of list
    }
}
