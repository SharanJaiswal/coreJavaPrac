package kk.maps;

import java.util.Comparator;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TreeMap is implementing interface NavigableMap which extends interface SortedMap, which ensures that nodes are in sorted order. SortedMap is extending interface Map.
 * TreeMap since implementing NavigableMap, hence provides numerous utilities to navigate the nodes easily.
 * Nodes are sorted according to the natural ordering of keys or by the Comparator provided while calling constructor. Natural Ordering is compareTo() method from Comparable<> interface.
 * Providing Comparator is different thing but works.
 * Based on red-Black binary tree (Self-Balancing binary search tree).
 * Node has left and right pointers.
 * Time: Amortized O(Log N) for insert remove and get.
 */
public class JavaTreeMap {
    public static void main(String[] args) {

        // Notice that in lHS we are using SortedMap reference type variable instead of just Map to get additional functionality.
        SortedMap<Integer, String> map1 = new TreeMap<>(Comparator.comparingInt((Integer k) -> -k));  // decreasing order   // else we can pass:: [ (a,b) -> b-a ]
        map1.put(21, "SJ");
        map1.put(11, "PJ");
        map1.put(13, "KJ");
        map1.put(5, "TJ");
        map1.forEach((Integer k, String v) -> System.out.println("k: " + k + " v: " + v));  // Sorting is based on the Comparator provided.

        System.out.println(map1.containsKey(14));
        System.out.println(map1.get(13));
        System.out.println(map1.containsValue("Sharan"));

        System.out.println("=========================");
        SortedMap<String, Integer> map2 = new TreeMap<>();    // increasing order
        map2.put("SJ", 21);
        map2.put("PJ", 11);
        map2.put("KJ", 13);
        map2.put("TJ", 5);
        map2.forEach((String k, Integer v) -> System.out.println("k: " + k + " v: " + v));  // Sort based on the key, ie, String's compareTo method.


        // Below methods are specific to the SortedMap interface
        System.out.println(map1.firstKey());
        System.out.println(map1.lastKey());
        System.out.println(map1.headMap(13));   // print all the map entry whose key are towards the left of the given key, excluding that key
        System.out.println(map1.headMap(4));
        System.out.println(map1.headMap(99));
        System.out.println(map1.tailMap(13));   // all map entries towards right staring from this key, including this key map entry
        System.out.println(map1.tailMap(4));
        System.out.println(map1.tailMap(99));


        System.out.println("\n\nNAVIGABLE MAPS");
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");
        System.out.println(navigableMap);
        System.out.println(navigableMap.lowerKey(4));   // key strictly < 4, or else gives null
        System.out.println(navigableMap.higherKey(4));  // >
        System.out.println(navigableMap.ceilingKey(4)); // >=
        System.out.println(navigableMap.floorKey(4));   // <=
        System.out.println(navigableMap.lowerEntry(4));
        System.out.println(navigableMap.higherEntry(1));
        System.out.println(navigableMap.ceilingEntry(3));
        System.out.println(navigableMap.floorEntry(4));
        // And many other methods
    }

}
