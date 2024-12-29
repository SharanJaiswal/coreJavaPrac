package kk.maps;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class JavaIdentityHashMap {
    public static void main(String[] args) {
        Map<String, Integer> stringHashMap = new HashMap<>();
        String key1 = new String("key");
        String key2 = new String("key");
        // String's hashCode gets computed on the value of the actual string. Which means, both of the above strings will have same hashCode. This implies collision, hence .equals() will be used to lexicographical comparison.
        // This .equals() will also return true, hence in the that bucket the new node will replace the first node.
        stringHashMap.put(key1, 1);
        stringHashMap.put(key2, 2);
        System.out.println(stringHashMap);  // It is evident that only one node is present in the String hash map.

//        By default, preferred hashCode() method is taken from the class of which obj is in context. If absent, then its subsequent parent is considered for hashCode(). If nothing is present, IdentityHashCode() ie, Object.hashCode() computes mem-loc.
//        In case, if IdentityHashCode() also gives the same hashCode, then collision gets resolved using operator "==" instead of .equals() method
//        But if, We use IdentityHashMap, then for calculation of hashCode of key always the Object.hashCode() will be called, irrespective of the overridden hashCode() method in the <? super key> classes.

        Map<String, Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(key1, 1);
        identityHashMap.put(key2, 2);
        System.out.println(identityHashMap);

        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));
    }
}
