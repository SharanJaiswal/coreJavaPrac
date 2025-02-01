package kk.sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashSet internally uses HashMap, where key is the actual entry in the set but value is the dummy object. Non-ordered.
 * Initial capacity of HashBucket:Array[16] (in heap mem); Load-factor of HashSet:0.75|75%|initial-12-buckets. Threshold: cur-capacity(16{entry count})*load-factor; Rehashing: when load-factor reaches certain threshold(12) (75%, initially when 12 k-v are added), capacity doubles.
 * Bucket Index= (hashCode) & (bucketLength - 1)
 * 16 or 12 here above represents the count of data elements currently in the Set or HashSet. It is not related to size of hash bucket, ie, unique count of hash indexes.
 * First, ((hash gets created using key)%bucket_size) => idx of hashbucket is found using hash of an object => check for hash-collision =N=> add element as first node =Y=> check if same key present in a given linkedlist of bucket. =N=> add as last node =Y=> don't add
 * Elements having same equals(key) value after hash collision doesn't get added.
 * We have to override equal() method because an element will only get added to the Set iff its eleKey.equals(already present ele key, if any) holds false
 * Also, a Set can have one "null" element. Although, it has nothing to do with equals() methods. equals(method) needs non-null object reference, or null reference must be handled.
 * Like Set's contains(), methods add() and remove() operation also return a boolean value; true if they perform as expected; false if they couldn't.
 * To make custom hashing algorithm, make sure that o1.equals(o2) is true, and o1.hashcode()==o2.hashcode() is true.
 *
 * hash contract: In default implementation, if obj1==obj2 holds true (equals() gives true), then hash(both objs) should be equal everytime. If Hash of 2 objects are same, that doesn't mean they are same objects.
 *
 * Not thread-safe, no insertion order maintained, Allows only 1 null element, no duplicates are allowed.
 *
 * HashSet, LinkedHashSet, TreeSet (Implementing NavigableSet and SortedSet), EnumSet
 * ConcurrentSet and its implementations to look for
 * CopyOnWriteArraySet logic is same as CopyOnWriteArrayList
 *
 * Collections.unmodifiableSet(SetItemObject)
 * Set.of() can take as many entries, and are not limited to count of 10.
 * There is nothing like Map.entries(Map.entry(k,v), ...)
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

        System.out.println(set.add(null));  // added at 0th index of hash bucket
        System.out.println(set);
        System.out.println(set.remove(null));
        System.out.println(set);

        /**
         * First, hash gets created => idx of hashbucket is found using hash of an object => check for hash-collision =N=> add element as first node =Y=> check if same key present in a given linkedlist of bucket. =N=> add as last node =Y=> don't add
         * Every element that gets added to HashSet, first gets its hashCode(). There might be cases where collision of hasCodes happens.
         * In that case, each hashCode present in hashBucket, points to a LinkedList, where each element of linkedlist has one pointer referring to next node with same hashCode(data)
         * add(data) O(1); remove(data) Amortized O(1) {because O(N) can only be possible where each element has same hashCode for collision. Assuming, collision is very rare.}
         * contains(data) O(1) {Because of same reason as above.}
         * HashSet() doesn't maintain the order of adding the elements
         */

        /**
         * LinkedHashSet<>() maintains the insertion order of elements. HashBucket is same, containing the different hashCodes pointing to different LinkedList for each hashCode in bucket.
         * But, each node in LinkedList has 3 pointers, one points to next node in the LinkedList of same HashCode(data). Another 2 points to node of before and after data which is added to the set,
         * where subsequent data added might be in different LinkedList of another hashCode(data).
         * add() O(1); contains() O(1); next() O(1); remove(data) O(1)
         */
        Set<String> set2 = new LinkedHashSet<>();


        // Threadsafe version:
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        Set<Integer> threadsafeversion =  hashMap.newKeySet();
        // Its iterator is also threadsafe, hence we can use add() method from iterator object itself, as it won't throw ConcurrentModificationException because internally it is synchronized.
        // Complexity is same as hashmap: add O(1), remove Amortized O(1), contains amortized O(1)
    }
}
