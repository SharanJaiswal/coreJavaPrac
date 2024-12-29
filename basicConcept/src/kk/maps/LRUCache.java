package kk.maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The idea is to remove the least readed element from a cache memory of fixed size whenever there is size issue while adding a new element to the cache
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int initialCapacity;

    public LRUCache(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.initialCapacity = initialCapacity;
    }

    // If we don't override this method, then linked hash map will retain all the elements added to it. But once we define our own logic(condition) to remove the eldest element when new element is added, then it behave like LRU cache
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//        return super.removeEldestEntry(eldest);
        return size() > initialCapacity;
    }

    public static void main(String ...args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 89);
        studentMap.put("Ram", 91);

        studentMap.get("Bob");  // moved entry with key "Bob" to the very last of linkedhashmap

        studentMap.put("Vipul", 89);    // this removed the entry from the LinkedHashMap with key "Alice"

        System.out.println(studentMap);
    }
}
