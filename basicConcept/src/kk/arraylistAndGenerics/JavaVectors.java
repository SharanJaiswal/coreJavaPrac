package kk.arraylistAndGenerics;

import java.util.Vector;

/**
 * Thread-safe, Synchronized, part of List, works like ArrayList but inefficient because it is slow, because it puts lock when any operation is performed on it, unlocks after completion.
 * It has all the methods of List Interface. It is present even before the Collection Framework from JDK1.0
 * duplicates allowed, null allowed, maintains insertion order.
 * Dynamic array
 */

public class JavaVectors {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();   // we can provide the initialCapacity. We can provide capacityIncrement which is no of slots that gets added when resizing happens in the underlying array, instead of doubling the capacity.
        // Vector provides the utility to check the current capacity of the underlying array.
        System.out.println(vec.capacity());

        vec.add(89);    // we can also use .add(idx,element)
        // We can also use addAll(idx, collectionItem), addAll(collectionItem), addAll()

        System.out.println(vec.get(0));
        vec.set(1,45);  // .set(idx, ele)
//        remove(idx|ele);
        System.out.println(vec.size());
        System.out.println(vec.isEmpty());
//        vec.contains(ele) {true if object element is present}     we can also provide vec.containsAll(collectionItem)    {true if all the ele form collectionItem is present }

        System.out.println(vec.get(0));
//        vec.clear();    // to just remove all the elements from the vector.

//        vec.remove(0);    // We can also use remove(element), remove()
//        vec.removeAll(CollectionItem)   // removes the common item
//        vec.removeIf(Predicate)
    }
}
