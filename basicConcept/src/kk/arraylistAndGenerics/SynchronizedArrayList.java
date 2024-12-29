package kk.arraylistAndGenerics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        // while add or removing the element from this list, a new copy of list is created and then write operation is performed onto it.
        // Once write operation is done, the reference of the array list in heap is then starts pointing to this newly updated arrayList.
        // While, during all these, read operation is performed on the original list.
        // Use this data structure only when there are more read operations and very less write operations, as here, write operation is expensive.


        // ArrayList cannot do concurrent write while reading it. It ALSO CANNOT  do it while accessing it form the multiple threads
//        Below will throw and error if ArrayList is used instead of CopyOnWriteArrayList
        List<String> stringList = new CopyOnWriteArrayList<>();
//        List<String> stringList = new ArrayList<>();
        stringList.add("Sharan");
        stringList.add("Saint");
        stringList.add("Jaiswal");

        for(String str : stringList) {
            System.out.println(str);
            if(str.equalsIgnoreCase("Saint")) {
                stringList.add("Mr");
                // Even though we added the element on the list, but this value is not get reflected in the list which is in current loop iterations, because, the write list reference will get updated once the read operation will get over.
                System.out.println("Added new element");
            }
        }
    }
}
