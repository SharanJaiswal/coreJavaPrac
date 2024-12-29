package kk.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JavaImmutableHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1. put("B", 2);
        // We created a map, we want it to be unmodifiable
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map1);   // Any changes in this map will throw an exception.
//        unmodifiableMap.put("C", 3);    // this will throw an error
        // But our requirement was not to change the "map1" itself. We still can modify the map "map1". This Map created is just the view of the snapshot of underlying Map.

//        Another approach::: maximum 10 k-v are only allowed
        Map<String, Integer> unmodifiedMap = Map.of("A", 1, "B", 2, "C", 3);    // Have limited k-v pairs, upto 10 entries of k-v pair

//         Another Approach
        Map<String, Integer> stringIntegerMap = Map.ofEntries(Map.entry("A", 1), Map.entry("B", 2), Map.entry("C", 3)); // This truly unmodifiable map, has nothing to do with the underlying map1, as it is not related to it.
    }
}
