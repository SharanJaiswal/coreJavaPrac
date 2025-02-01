package kk.javaqueues;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Double ended queue, addition and removal can be done from both the ends.
 * Thread unsafe. Maintains insertion order. no null addition allowed.
 */
public class JavaDeque {
    public static void main(String[] args) {

        // ArrayDeque is an implementation of Queue, which can work as Stack also. It is faster than Stack, than Stack itself; faster than LinkedList when used as Queue.
        // Underlying array is used as a circular array. This makes the resizing happens only when there is need of the more space to store more elements.
        /**
         * Few methods are::
         * offerFirst() and OfferLast() are preferred over addFirst() addLast()
         * peekFirst() and peekLast() are preferred over getFirst() and getLast()
         * pollFirst() and pollLast() are preferred over removeFirst() and removeLast()
         *
         * It also have few Stack methods:
         * pop() and push(), which are similar to pollFirst() and offerFirst() methods
         */
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        queue.addLast(5);
        queue.addLast(10);
        System.out.println("Queue first ele remove: " + queue.removeFirst());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(1);
        stack.addFirst(5);
        stack.addFirst(10);
        System.out.println("Stack first ele remove: " + stack.removeFirst());


        // Thread-safe ArrayDeque:
        ConcurrentLinkedDeque<Integer> threadsafeDeque = new ConcurrentLinkedDeque<>();
        // there are many Concurrent version of many data structures.
    }
}

/**
 * Insertion: we only add it on first or last. So O(1) amortized. But in cases when baseline array resize happens, then O(n).
 * Deletion: O(1) because we do deletion on first and last only.
 * Searching: Examination happens at first or last only. O(1)
 * Space: O(n)
 */