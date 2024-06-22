package kk.sets;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Internally uses linked hash map, maintaining insertion order, not threadsafe.
 * Only insertion order, not access order.
 * Same complexities as LinkedHasMap
 */
public class JavaLinkedHashSet {
    public static void main(String[] args) {


        // threadsafe version:
        Map<Integer, Object> map = Collections.synchronizedMap(new LinkedHashMap<>());
        Set<Integer> set1 = map.keySet();
    }
}
