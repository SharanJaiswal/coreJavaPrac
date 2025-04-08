package kk.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * If 2 objects are giving same value of .equals() , then their .hashCode() should also give same value. Its is present as default implementation. In default implementation, .equals() compares the address of objects in the heap memory. Obj address is also used by hashCode() method.
 * In hash based collections, even if we are overriding either of equals() or hashCode() methods, we must ensure that if 2 objects give same value of .equals(), then their hashCode() values should also be same, and vice-versa.
 * When there is NOT the case of hash based collections, it is NOT ALWAYS required that when we override hashCode() we need to override equals(). But in any case, if equals() is overridden, hashCode() needs to be overidden, to maintain the integrity of equals() and hashCode() contract; as equals() uses hashCode() in its default behavior, and we need to continue the same behavior.
 */

/**
 * MAP DOESN'T EXTEND COLLECTION INTERFACE. It has its own set of methods, and iterator methods.
 * Object -> Hash Function|Logic -> Hash Code (One way only) ===> (hashCode & (bucketLength - 1)) gives bucket index. If 2 hash-collision happens, then keys are compared using .equals() method.
 * If keys found different () (ie, when .equals() give false) then entry is added as next LL node, otherwise replace existing node.
 * After hash collision, element replaces existing node with same value of equals().
 * If a certain bucket contain LL with node count > TREEIFY_THRESHOLD = 8, then that LL becomes red-black tree (binary tree - self-balancing tree) in O(log N), where it sorts and place nodes in tree (left-right child) by using compareTo() on keys.
 * < UNTREEIFY_THRESHOLD = 6 ==> makes LL again.
 * Node replacement is possible when hash-collision happens and equals() gives value as true.
 *
 * NOT thread-safe; can store null key or value. NOT maintains insertion order.
 */
public class JavaHashMaps {
    public static void main(String[] args) {
        Map<Integer, Student> students = new HashMap<>();   // We can use HashMap in LHS instead of simply using Map to get more functionality specific to HashMap
        Student stu1 = new Student("Foo", "Bar", 2, "Science");
        Student stu2 = new Student("Baar", "Baz", 1, "Commerce");
        Student stu3 = new Student("Blah", "Barrr", 3, "Arts");
        Student stu4 = new Student("Ehhh", "Burrraahhh", 3, "Humanities");

        System.out.println(students.put(stu1.getId(), stu1));
        System.out.println(students.put(stu2.getId(), stu2));
        System.out.println(students.put(stu3.getId(), stu3));
        System.out.println(students.put(null, stu4));

        System.out.println(students);

        System.out.println(students.get(1));    // st2
        System.out.println(students.get(null)); // stu4

        // null check : Both gives null. So, putting value as null in the map is not advised, as it won't give the clear picture as if key-value pair is missing or the value is null.
        students.put(200, null);
        System.out.println(students.get(200));  // whose value is set as null
        System.out.println(students.get(300));  // whose key isn't in the HashMap


        /**
         * Maps don't have iterators because maps are not group of elements; they are group if map elements. We can iterate via key or value or both.
         * While iterator works on elements itself.
         */
        System.out.println("=============Map KeySet iteration==========");
        for (Integer id :
                students.keySet()) {
            System.out.println(id);
        }
        System.out.println("=============Map Value iteration==========");
        for (Student stu :
                students.values()) {
            System.out.println(stu);
        }

        // Below both uses .equals() method to compare for the required existence
        System.out.println(students.containsKey(stu1.getId()));
        System.out.println(students.containsValue(stu2));

        // HashMap has a sub-interface Entry
        System.out.println("=============Map Key-Value iteration==========");   // Maps has structure called Map.Entry<K, V>
        for (Map.Entry<Integer, Student> entry:
                students.entrySet()){   // Although, map.entrySet() gives value of type Set<Map.Entry<K, V>>
            entry.setValue(entry.getValue());   // We can do some modification if required, but better approach would be to use compute() inside this loop
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }

        System.out.println("=============Get Default Value if key doesn't exists==========");
        System.out.println(students.getOrDefault(34, new Student("Sharan", "Jaiswal", 716, "CSE")));

        System.out.println("=============Put K-V in Map if key doesn't exists==========");
        students.putIfAbsent(897, new Student("Saint", "Sharan", 4536, "IT"));
        System.out.println(students);

        System.out.println("=============for Each==========");
        students.forEach((key, value) -> System.out.println(key + "==>" + value));

        System.out.println("=============Map computeIfAbsent==========");   // All 3 returns object of value. Modifies underlying map in certain cases. Also look compute, computeIfPresent, computeIfAbsent
        // For a given key, if kv- pair is absent or v is null, then the same key will be a param to lambda which can return the value of type <? extends V> (in general). This key and computed value will be added to map, ie modify the map. If computed value is null, then this new KV will not get added to map because computed V is null.
        // If for given key, KV is present and its V is not null, then irrespective of the computed value, the original KV will not get changed in the map.
        Student student = students.computeIfAbsent(111, k -> new Student("Shrn", "Jswl", k, "CSE"));    // it returns computed non-null value, and modifies map by adding KV in map. Also returns the computed value.
        students.computeIfAbsent(1, k -> new Student("Shrrrrrrrrrn", "Baz", 1, "CSE")); // orig KV is present where V is not null. So computed value will not replace original V in KV in map.
        students.computeIfAbsent(200, k -> new Student("Shrrrrrrrrrn", "Baz", 1, "CSE"));   // Orig KV present with V as null. So computed V will replace V in map
        students.computeIfAbsent(2, k -> null);
        System.out.println(students.get(111));
        System.out.println(students.get(1));
        System.out.println(students.get(200));
        System.out.println(students.get(2));    // Does not drop original KV from map if computed value gives null. Unlike other 2 compute() and computeIfPresent() where if computed V is null, then orig KV is dropped from map.

//        students.compute()  // takes key, and a BiFunction taking K,V and returning a computed value. But if Computed value is NULL, then orig KV is removed from the map if present already. or it is NOT added in the list with (K, null) as new K,V pair.
//        students.computeIfPresent() // does same thing but iff the key is present. If computed value is NULL, then that key value is removed from the list. Takes the BiFunction

        /**
         * for HashMap, get() O(1) uses hash-code, containsKey (1) uses hash-code, put O(1). BOTH ARE AMORTIZED.
         * In HashMap, for one key, gives one hashcode, mapped to only one value.
         */


        // ThreadSafe:
        ConcurrentHashMap<Integer, String> threadSafeHashMap = new ConcurrentHashMap<>();
    }
}

/**
 * Storing of k-v in hashmap internally:
 * There is an array of Node where each Node implementing sub-interface Map.Entry in HashMap class stores hash-k-v-next(ofNode for a given LL of hash).
 */
