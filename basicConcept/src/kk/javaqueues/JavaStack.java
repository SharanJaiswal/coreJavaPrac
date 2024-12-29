package kk.javaqueues;

import java.util.LinkedList;
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
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());    // Throws EmptyStackException on empty stack
        // and many other methods of Vectors, Queue.

        Integer peek = stack.peek();    // not to pop, but simply just to see what's at the top. Throws EmptyStackException on empty stack
        System.out.println(peek);

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        // Interesting thing is, since stack is extending the Vector class, hence it has many other methods which does many work
//        stack.add(ele)  // add(idx), addAll(collectionItem), addAll(idx, collectionItem)
//        stack.remove(ele)   // remove(idx), removeAll(collectionItem), removeIf(Predicate)

        // Another stack functionality is search which is "1" based indexing.
        System.out.println(stack.search(5));    // gives the index of this element from the top. Uses the .equals() method to compare the object element.
        // IT RETURNS THE -1 AS THE RESPONSE WHEN COULDN'T ABLE TO FIND THE ELEMENT IN THE LIST.


        // We can also use LinkedList as Stack::: because linkedlist in java is doubly linked list to play with it as stack
        LinkedList<Object> linkedList = new LinkedList<>();

        // In linkedlist, add() and addLast() works in the same way. This works as the push() of stack
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(1);

        // peek
        System.out.println(linkedList.getLast());

        // pop
        linkedList.removeLast();

        linkedList.clear();
        linkedList.size();
        linkedList.isEmpty();


        // Same can be implemented using the ArrayList, but we don't do that. It's really not required, at all.
    }
}
