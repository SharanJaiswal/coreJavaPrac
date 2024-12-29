package kk.javaqueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {

        // Queue is an interface which has 2 primary implementations - LinkedList and ArrayDeque. LinkedList is used for better write|add nodes, while ArrayDeque is used for read operations prominent operations.
        // Priority queue is just another queue with special requirement of element ordering.
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);    // enque    ----  add and addLast works asame for the given LinkedList
        list.addLast(2);    // enque
        list.addLast(3);    // enque
        System.out.println(list);
        Integer i = list.removeFirst(); // dequeue
        System.out.println(list);
        System.out.println(list.getFirst());    // peek

        // We can use reference variable of Queue type, which has .add() method to enqueue the element in the queue. LinkedList also implements the Deque
        // In queue:: for enqueue->add & offer; for dequeue->remove & poll; for peek->element & peek
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        System.out.println(queue1.size());  // 1
        System.out.println(queue1.remove());    // throws exception if empty
        System.out.println(queue1.poll());      // gives null instead of throwing the exception if the queue is empty
//        System.out.println(queue1.element());   // throws and exception if empty
        System.out.println(queue1.peek());      // gives null in case of empty queue, instead of throwing an exception

        // Below type of Queue is for queue of fixed size. Above we were just using the linkedList, referring it via a Queue interface.
        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        System.out.println(queue2.add(1));  // true
        System.out.println(queue2.offer(2));    // true
        // till here, everything is good, but below, if we try adding element using .add() then it will throw an exception, while offer will just return a false.
//        System.out.println(queue2.add(3));  // throws exception
        System.out.println(queue2.offer(3));    // returns false, as it couldn't add a new element to already filled queue.
    }
}
