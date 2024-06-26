package kk.arraylistAndGenerics;
/*
Dynamic size is not actually true. Internally, the size is fixed and using Array DS, but keeps on changing until certain threshold is reached. When element count threshold hits,
new ArrayList is created, elements from old arraylist are copied to new one, new arraylist reference replaces the old arraylist, old arraylist gets deleted.
All this happens seamlessly.
Insertion O(1) when threshold hasn't reached; O(N) threshold reached; O(N) adding at specific index.
Deletion: O(N)
Search: O(1) since Arrays underlies.
Space: O(N)

Not thread-safe; maintains insertion order, null allowed, duplicates allowed.
 */

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // syntax: LHS should have the datatype of elements inside diamond operator. RHS can also have it, but it's redundant to have same datatype there in <> in RHS
        // () calls constructor in RHS can have initialCapacity of ArrayList.
        // In Java, <> cannot have primitive data types inside it.
        // Therefore, to make generics compatible with primitive data types, there is an autoboxing of primitives, makes them derived type of Java Object, called wrapper objects.
        ArrayList<Integer> arrayList = new ArrayList<>();

        ArrayList<Integer> arr1 = new ArrayList<>(5);
        arr1.add(234);  // Best:O(1); Worst:O(N); Amortized:O(1) -> Distribute rare worst case among previous N best cases. Hence, add in constant time overall.
        arr1.add(12);
        arr1.add(546);
        arr1.add(38);
        arr1.add(90);

        System.out.println(arr1.contains(10));  // false
        System.out.println(arr1.contains(234)); // true
        System.out.println(arr1);   //[234, 12, 546, 38, 90]
        arr1.set(2,34567);
        System.out.println(arr1);   // // [234, 12, 34567, 38, 90]
        arr1.remove(1);
        System.out.println(arr1.remove(new Integer(90)));   // true
        System.out.println(arr1);   // [234, 34567, 38]
        arr1.add(1, 407);
        System.out.println(arr1);   // [234, 407, 34567, 38]
        
        // Input in arrayList
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            arr1.add(scanner.nextInt());
        }
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(arr1.get(i));    // syntax like arr1[idx] will not work here
        }

        ListIterator<Integer> lstItr = arr1.listIterator();
        // next and previous points to the address of next element. When we call them, it returns that element and then moves next|previous element,
        // Rather first moving next|previous and then returning element.
        System.out.println(lstItr.next());  // 234
        System.out.println(lstItr.previous());  // 234
        // nextIndex() can be size of array if pointing last, and previousIndex() can be -1 if pointing to first element.


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
        // boolean remove(int idx | E ele)  // either take the index to remove the element at that index, or pass the element itself to remove the first occurrence of the element.
//        arr1.retainAll(any other collection);   // arr1 will have only those elements which will be common to arr1 and collection item passed
//        arr1.replaceAll();  // takes UnaryOperator type instance which is basically a lambda which takes one element at a time as an input from arr1,
        // and transforms and returns an element of type of list
        // splitIterator()
        // contains(Collections coll)   O(n^2)

        /**
         * List has also their own custom iterator method which return iterator of type ListIterator<E> listIterator([int startIdx]);
         * This returned listIterator type instance have few more instance methods along with conventional iterator methods like hasNext(), next(),
         * remove() {supports next() and previous()} {supports selective List type only}, forEachRemaining():
         *
         * add(E ele) {supports selective List type only}, hasPrevious(), nextIndex() {returns idx of element that would be returned by next()}, previous(), previousIndex(), set(E ele)
         */


        // Thread-safe version:
        CopyOnWriteArrayList<Integer> threadsafeArrayList = new CopyOnWriteArrayList<>();
    }
}
