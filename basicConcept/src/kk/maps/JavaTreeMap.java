package kk.maps;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Nodes are sorted according to the natural ordering of keys or by the Comparator provided while calling constructor.
 * Based on red-Black binary tree (Self-Balancing binary search tree).
 * Node has left and right.
 * Time: Amortized O(Log N) for insert remove and get.
 */
public class JavaTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new TreeMap<>(Comparator.comparingInt((Integer k) -> -k));  // decreasing order
        map1.put(21, "SJ");
        map1.put(11, "PJ");
        map1.put(13, "KJ");
        map1.put(5, "TJ");
        map1.forEach((Integer k, String v) -> System.out.println("k: " + k + " v: " + v));

        System.out.println("=========================");
        Map<Integer, String> map2 = new TreeMap<>();    // increasing order
        map2.put(21, "SJ");
        map2.put(11, "PJ");
        map2.put(13, "KJ");
        map2.put(5, "TJ");
        map2.forEach((Integer k, String v) -> System.out.println("k: " + k + " v: " + v));
    }

}
