package kk.javaqueues;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Min priority queue: min heap. Max Priority Queue: max heap. Elements are ordered either by default using Natural Ordering(for primitives, lowest first) or by comparator passed to constructor while creating object of it.
 * add() - offer() -> O(log N)
 * remove() - poll() -> for head:O(log N) - for nth element except head: O(N)
 * element() - peek() -> O(1)
 * Thread unsafe. Not maintains insertion order. No null addition allowed.
 *
 * MIN HEAP:: It is simple binary tree, but the every node will either be equal to or smaller of their both the children. This makes the top-most node as smallest in the entry elements
 */
public class JavaPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();    // default: min heap
        minQueue.add(5);
        minQueue.add(2);
        minQueue.add(8);
        minQueue.add(1);
//        minQueue.forEach(System.out::println);  // (Integer val) -> System.out.println(val)
        while(!minQueue.isEmpty()) {
            System.out.println("remover from top in order of min heap storage: " + minQueue.poll());
        }

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((Integer a, Integer b) -> -Integer.compare(a, b));    // provide custom comparator change the natural order.
        maxQueue.add(5);
        maxQueue.add(2);
        maxQueue.add(8);
        maxQueue.add(1);
        while(!maxQueue.isEmpty()) {
            System.out.println("remover from top in order of max heap storage: " + maxQueue.poll());
        }

        // Thread-safe version:
        PriorityBlockingQueue<Integer> threadsafeMinHeap = new PriorityBlockingQueue<>();
    }
}
