package kk.arraylistAndGenerics;
/*
Dynamic size is not actually true. Internally, the size is fixed and using Array DS, but keeps on changing until certain threshold is reached (10). When element count threshold hits,
new ArrayList is created, elements from old arraylist are copied to new one, new arraylist reference replaces the old arraylist, old arraylist gets deleted.
All this happens seamlessly. ArrayList growth-factor is 1.5x
Insertion O(1) when threshold hasn't reached; O(N) threshold reached; O(N) adding at specific index.
Deletion: O(N)
Search: O(1) since Arrays underlies.
Space: O(N)

Not thread-safe; maintains insertion order, null allowed, duplicates allowed.
 */

/**
 * Lsit is an interface which ensures that classes implementing it, can put duplicate elements maintaining the insertion order. List is extended by ArrayList, LinkedList, Vector, Stack
 */

import kk.lambdas.Student;
import kk.oops.Students;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // syntax: LHS should have the datatype of elements inside diamond operator. RHS can also have it, but it's redundant to have same datatype there in <> in RHS due to type-inference.
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

        System.out.println(arr1.contains(10));  // false - uses Object.equals(arr1[i], 10)
        System.out.println(arr1.contains(234)); // true
        System.out.println(arr1);   //[234, 12, 546, 38, 90]
        arr1.set(2,34567);
        System.out.println(arr1);   // // [234, 12, 34567, 38, 90]
        arr1.remove(1);
        System.out.println(arr1.remove(new Integer(90)));   // true// arr1.remove(Integer.valueOf(564));   to remove the object, as remove proves 2 functionality; first takes index and another takes the element in the list itself where first matching occurrence will get removed.
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


        // ArrayList to Array::::
        Object[] array = arr1.toArray();    // this returns the array of Object type, but we want an array of Integer type.
        Integer[] array1 = arr1.toArray(new Integer[0]);    // we passed 0 sized array because we just needed to tell what type of array we want. Although, output size is same as of arr1.
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));

        Collections.sort(arr1); // we can pass Comparator as the second argument also.
//        arr1.sort();    // need comparator, hence giving error.
        arr1.sort(null);
        // There are few methods by which we can pass the comparator.
        // 1. defining a new class implementing Comparator
        // 2. passing lambda directly as considering 'a', and 'b' as complex objects, (a,b) -> { logic to compare attributes of 'a' & 'b' }
//        3.  Comparator<Students> stComp = Comparator.comparing(Student::getMarks).reversed().thenComparing(Students::getName().length());

        System.out.println(arr1.isEmpty());


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
        // boolean remove(int idx | E ele)  // Uses Object.equals(o, ele); either take the index to remove the element at that index, or pass the element itself to remove the first occurrence of the element.
//        removeAll(Collection) ; removeIf(Predicate)
//        arr1.retainAll(any other collection);   // arr1 will have only those elements which will be common to arr1 and collection item passed
//        arr1.replaceAll();  // takes UnaryOperator type instance which is basically a lambda which takes one element at a time as an input from arr1,
        // and transforms and returns an element of type of list
//        Spliterator<Integer> spliterator = arr1.spliterator();
//         arr1.containsAll(Collections coll)   O(n^2)
//        arr1.contains(Object obj)     // uses Object.equals(arr1[i], obj), ; also works if checked for null and null is present in the array.

        /**
         * List has also their own custom iterator method which return iterator of type ListIterator<E> listIterator([int startIdx]);
         * This returned listIterator type instance have few more instance methods along with conventional iterator methods like hasNext(), next(),
         * remove() {supports next() and previous()} {supports selective List type only}, forEachRemaining():
         *
         * add(E ele) {supports selective List type only}, hasPrevious(), nextIndex() {returns idx of element that would be returned by next()}, previous(), previousIndex(), set(E ele)
         */
        // Iterable interface has iterator abstract method, along with hasNext() next() and remove() method. While in ArrayList, we cannot modify it while it is in loop, but iterator provides us that functionality.

        ListIterator<Integer> lstItr = arr1.listIterator();
        // next and previous points to the address of next element. When we call them, it returns that element and then moves next|previous element,
        // Rather first moving next|previous and then returning element.
        System.out.println(lstItr.next());  // 234
        System.out.println(lstItr.previous());  // 234
//        remove, previous, hasPrevious, next, hasNext, add, set, nextIndex, previousIndex, forEachRemaining(Consumer)
        // nextIndex() can be size of array if pointing last, and previousIndex() can be -1 if pointing to first element.


        // Thread-safe version: See SynchronizedArrayList
        CopyOnWriteArrayList<Integer> threadsafeArrayList = new CopyOnWriteArrayList<>();
    }
}
