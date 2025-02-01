package kk.linkLists;

import java.util.LinkedList;

/**
 * For add or remove element at the head, its O(1). While for any place beyond 0th place, the operation is split into 2 operation: traverse [get:O(N)], and then add|remove: O(1).
 * implements List and Deque. getFirst(), getLast(), removeFirst(), removeLast(), etc. from Deque. Also, get(idx), add(idx, obj), etc.
 * This doesn't have underlying array type. So, works as an actual LL, with last node and first node awareness. Hence, it is faster than arraylist because no copying after threshold.
 * Insertion: O(1) for start and end, O(n) at specific position as lookup is O(n)+O(1) or insert at the particular idx,
 * Search: O(N)
 * Delete: same as insert.
 * space: O(N)
 * Maintains insertion order, duplicates allowed, null allowed, NOT thread-safe.
 * Insertion and Deletion happens at lesser cost because unlike ArrayList, we don't have to create new bigger array.
 * Random access is slower, as iteration from start/end is involved.
 * It has memory overhead, storing the next|previous etc. dta structure in the Node.
 */
public class linkList {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>(); // better we write LinkedLit in the LHS. If we reference it using type List, then, some methods will not be recognized as they are specific to the linked List.
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.add(3);
        integerLinkedList.add(4);
        integerLinkedList.add(4, 5);

//        integerLinkedList.addAll(idx, collection_item); // We can skip idx in which case the collection item elements will be appended at the last.

        // Collection framework provides the .get() method for linkedlist, for direct access the node at idx i. Although, internally it traverse.
        Integer data2 = integerLinkedList.get(2);
        // Java provides the doubly linked list, so we have other few methods also, abstracting the real logic
        integerLinkedList.add(2, Integer.valueOf(11));
        integerLinkedList.addLast(45);  // O(n)
        integerLinkedList.addFirst(69); // O(n)
        System.out.println(integerLinkedList.getFirst() + " === " + integerLinkedList.getLast());

        // Remove has also few variations: remove({nothing (for head node removal), idx, ele})
//        integerLinkedList.remove();
//        integerLinkedList.removeFirst();    // removeLast()
//        integerLinkedList.removeFirstOccurrence();  // removeLatsOccurrence()
//        integerLinkedList.removeAll(collection_item);   // removes common elements from the linked list
            integerLinkedList.removeIf((num) -> (num.compareTo(-1) < 0));   // takes Predicate for conditional removal

        System.out.println(integerLinkedList.isEmpty());
    }
}
