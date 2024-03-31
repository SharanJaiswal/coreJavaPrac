package kk.arraylistAndGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * So, asList takes series of Object or ts derived types. Since, we are passing primitive type, hence auto-boxing is taking place, giving Lis of Integers.
 * AUto-unboxing is taking place when Integer type is getting cast into primitive type.
 */

public class ArraysDS {
    public static void main (String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30);
        int i = list.get(0);
        System.out.println(list.get(0));


        List<String> list1 = new ArrayList<>();
        list1.add("One");
        list1.add("Two");

        String s = list1.get(0);

        Iterator<String> iterator1 = list1.iterator();
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        Iterator<String> iterator2 = list1.iterator();
        Iterator<String> iterator3 = list1.iterator();

        iterator3.next();
        iterator3.remove(); // If by any chance, we called this method prior to calling next(), then IllegalStateException will be thrown,
        // because iterator needs to point some element to get it removed from the underlying collection item, and hence iterator.
        // Once remove() has been called, we cannot call another remove() without calling next(), because it will throw IllegalStateException
//        iterator3.remove();
        System.out.println(iterator3.next());
        System.out.println(list1);

        list1.add("new item");
//        System.out.println(iterator2.next());     // ConcurrentModificationException underlying collection item has been changed.
    }
}
/**
 * Iterators is being implemented by all collections type and its downstream child classes. Iterator<E> interface has only 2 methods:
 * boolean hasNext(), E next(), void remove(), default void forEachRemaining(Consumer<? super E> action)
 * We can have may iterators simultaneously pointing to the Collections item. next() just gives the reference of the next present element.
 * remove() is not supported by all the collections. Also, if the underlying collections item gets changed, then iterator throws exception stating that something has been changed.
 * ConcurrentModificationException means, eg, if something is added or removed from the collection item, then next() is still pointing to the same element prior to change,
 * and this breaks the contract of next(). Hence, it raises the exception.
 */