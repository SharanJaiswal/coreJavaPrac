package kk.oops.interfaces.deafultinterface;

public interface B {  // interface to interface inheritance uses"extends" keyword.
    void greet();

//    default void fun() {    // We cannot have simply 2 interfaces with same method signature with body
//        // Makes the dynamic dispatcher confuse, which body version to execute, of A's or of B's
    // See the last method to overcome this problem.
//        System.out.println("I am in A");
//    }

//    We can have more than 1 default methods in interfaces.
    // Class which is implementing those interfaces having default method, can also override them.
    default void seeoff() {
        System.out.println("bye Bye");
    }

    // We want to create method dispatch error at runtime in class Driver
    default void forConflict() {    // First see the first method of this interface, then come here. Same method is in A.
        System.out.println("Conflict picked from B");
    }
}
