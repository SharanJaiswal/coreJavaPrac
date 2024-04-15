package kk.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Initial capacity of HashBucket:Array[16]; Load-factor of HashSet:N/[buckets]; Rehashing: when load-factor reaches certain threshold, capacity doubles.
 * We have to override equal() method because an element will only get added to the Set iff its ele.equals(already present ele, if any) holds false
 * Also, a Set can have one "null" element. Although, it has nothing to do with equals() methods. equals(method) needs non-null object reference, or null reference must be handled.
 * Like Set's contains(), methods add() and remove() operation also return a boolean value; true if they perform as expected; false if they couldn't.
 * To make custom hashing algorithm, make sure that o1.equals(o2) is true, and o1.hashcode()==o2.hashcode() is true
 */
public class Sets {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("Sharan"));
        set.add("Jaiswal");
        System.out.println(set.add("Jaiswal"));
        System.out.println(set);

        System.out.println(set.remove("Jai"));
        System.out.println(set.remove("Jaiswal"));
        System.out.println(set);

        System.out.println(set.contains("Sharan"));
        System.out.println(set.contains("Jaiswal"));

        System.out.println(set.add(null));
        System.out.println(set);
        System.out.println(set.remove(null));
        System.out.println(set);

        /**
         * Every element that gets added to HashSet, first gets its hashCode(). There might be cases where collision of hasCodes happens.
         * In that case, each hashCode present in hashBucket, points to a LinkedList, where each element of linkedlist has one pointer referring to next node with same hashCode(data)
         * add(data) O(1); remove(data) Amortized O(1) {because O(N) can only be possible where each element has same hashCode for collision. Assuming, collision is very rare.}
         * contains(data) O(1) {Because of same reason as above.}
         * HashSet() doesn't maintain the order of adding the elements
         */

        /**
         * LinkedHashSet<>() maintains the insertion order of elements. HashBucket is same, containing the different hashCodes pointing to different LinkedList for each hashCode in bucket.
         * But, each node in LinkedList has 2 pointers, one points to next node in the LinkedList of same HashCode(data). Another points to node of next data which is added to the set,
         * where next data added might be in different LinkedList of another hashCode(data)
         * add() O(1); contains() O(1); next() O(1); remove(data)
         */
        Set<String> set2 = new LinkedHashSet<>();
    }
}