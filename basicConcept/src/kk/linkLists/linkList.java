package kk.linkLists;

/**
 * For add or remove element at the head, its O(1). While for any place beyond 0th place, the operation is split into 2 operation: traverse [get:O(N)], and then add|remove: O(1).
 * implements List and Deque. getFirst(), getLast(), removeFirst(), removeLast(), etc. from Deque. Also, get(idx), add(idx, obj), etc.
 * This doesn't have underlying array type. So, works as an actual LL, with last node and first node awareness. Hence, it is faster than arraylist because no copying after threshold.
 * Insertion: O(1) for start and end, O(n) at specific position as lookup is O(n)+O(1) or insert at the particular idx,
 * Search: O(N)
 * Delete: same as insert.
 * space: O(N)
 * Maintains insertion order, duplicates allowed, null allowed, NOT thread-safe.
 */
public class linkList {
    public static void main(String[] args) {

    }
}
