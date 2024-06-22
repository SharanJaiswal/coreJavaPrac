package kk.javaqueues;

import java.util.Stack;

/**
 * Stack class is a child of Vector Class, a thread-safe data structure. While Deque is not thread safe.
 * Stack methods are synchronized.
 * Null and duplicates are allowed, maintains insertion order.
 *
 * Insertion: O(1)
 * Deletion: O(1)
 * Search: O(1)
 * Space O(N)
 */
public class JavaStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(56);
        System.out.println(stack.pop());
        // and many other methods of Vectors, Queue.
    }
}
