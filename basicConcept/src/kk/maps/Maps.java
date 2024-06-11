package kk.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Map doesn't extend Collections. It has its own set of methods, and iterator methods.
 * Object -> Hash Function|Logic -> Hash Code (One way only)
 * After hash collision, element replaces existing node with same value of equals().
 * If a certain bucket contain LL with node count > TREEIFY_THRESHOLD = 8, then that LL becomes red-black tree, where it first sorts by hashCode(), and then by compareTo() if hash are same.
 * < UNTREEIFY_THRESHOLD = 6 ==> makes LL again.
 *
 */
public class Maps {
    public static void main(String[] args) {
        Map<Integer, Student> students = new HashMap<>();
        Student stu1 = new Student("Foo", "Bar", 2, "Science");
        Student stu2 = new Student("Baar", "Baz", 1, "Commerce");
        Student stu3 = new Student("Blah", "Barrr", 3, "Arts");
        Student stu4 = new Student("Ehhh", "Burrraahhh", 3, "Humanities");

        System.out.println(students.put(stu1.getId(), stu1));
        System.out.println(students.put(stu2.getId(), stu2));
        System.out.println(students.put(stu3.getId(), stu3));
        System.out.println(students.put(null, stu4));

        System.out.println(students);

        System.out.println(students.get(1));

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
        System.out.println("=============Map Key-Value iteration==========");   // Maps has structure called Map.Entry<K, V>
        for (Map.Entry<Integer, Student> entry:
                students.entrySet()){
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }

        System.out.println("=============Get Default Value if doesn't exists==========");
        System.out.println(students.getOrDefault(34, new Student("Sharan", "Jaiswal", 716, "CSE")));

        System.out.println("=============Put K-V in Map if Key doesn't exists==========");
        students.putIfAbsent(897, new Student("Saint", "Sharan", 4536, "IT"));
        System.out.println(students);

        System.out.println("=============for Each==========");
        students.forEach((key, value) -> System.out.println(key + "==>" + value));

        System.out.println("=============Map computeIfAbsent==========");   // Also look compute, computeIfPresent, computeIfAbsent
        // For a given key, if kv- pair is absent or v is null, then the same key will be a param to lambda which can return the value of type <? extends V> (in general).
        // If value returned is null, then that K-V is not added to map, otherwise, it will get added.
        students.computeIfAbsent(111, k -> new Student("Shrn", "Jswl", k, "CSE"));
        System.out.println(students.get(111));

        /**
         * for HashMap, get() O(1) uses hash-code, containsKey (1) uses hash-code, put O(1)
         * In HashMap, for on key, gives one hashcode, mapped to only one value.
         */
    }
}
