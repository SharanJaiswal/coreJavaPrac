package kk.arraylistAndGenerics;

import java.util.Vector;

/**
 * Thread-safe, works like ArrayList but inefficient because it is slow, because it puts lock when any operation is performed on it, unlocks after completion.
 * It has almost all the methods of ArrayList.
 * Thread-safe, duplicates allowed, null allowed, maintains insertion order.
 */

public class JavaVectors {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();
        vec.add(89);
        System.out.println(vec.get(0));
    }
}
