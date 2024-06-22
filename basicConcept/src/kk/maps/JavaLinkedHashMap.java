package kk.maps;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * HashMap doesn't maintain the order but LinkedHashMap provides 2 ordering: Insertion(default) & Access order. Only 1 order can be present at a time, decided while calling a constructor.
 * Access Order, ie, highly frequently used element should be at the last.
 * It uses Double Linked List. Where each node has 2 more fields, before and after which stores order of insertion.
 * forEach method of LinkedHashMap iterates over insertion order.
 *
 * Time complexity is same as of hashmap. O(1) amortized; O(N) worst; O(Log N) in tree case.
 * Not threadsafe, nor its threadsafe version available. but we can use Collections util class.
 */
public class JavaLinkedHashMap {
    public static void main(String[] args) {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75F, true);    // for access order
        linkedHashMap.put(1, "A");
        linkedHashMap.put(21, "B");
        linkedHashMap.put(23, "C");
        linkedHashMap.put(141, "D");
        linkedHashMap.put(25, "E");

        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap);

        // In access ordered linked hash map, most frequently access node is put at the end. It can be used at caching.
        linkedHashMap.get(23);
        linkedHashMap.get(141);
        linkedHashMap.forEach((Integer i, String s) -> System.out.println("k: " + i + " v: " + s));

        Map<Integer, String> map2 = Collections.synchronizedMap(new LinkedHashMap<>());
    }

}
