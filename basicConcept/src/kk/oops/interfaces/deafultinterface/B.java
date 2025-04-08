package kk.oops.interfaces.deafultinterface;

abstract public interface B {  // interface to interface inheritance uses "extends" keyword.
    public abstract void greet();

//    default void fun() {    // We cannot have simply 2 interfaces with same method signature with body
//        // Makes the dynamic dispatcher confuse, which body version to execute, of A's or of B's
////     See the last method to overcome this problem.
//        System.out.println("I am in B");
//    }

//    We can have more than 1 default methods in interfaces.
    // Class which is implementing those interfaces having default method, can also override them.
    default public void seeoff() {
        System.out.println("bye Bye");
    }

    // We want to create method dispatch error at runtime in class Driver
    default public void forConflict() {    // First see the first method of this interface, then come here. Same method is in A.
        System.out.println("Conflict picked from B");
    }


    // Interfaces can also have private methods. Since interfaces don't have any instances, hence private methods can be called from within the interface itself. Therefore, these private
    // methods can be called either via static methods, or by default methods. Any class that will be implementing that interface, cannot access this private method because it is private.
    // Suppose, like this class, we are having a bunch of default methods, and we want to execute a block of code for each default method. In that case, we can define a private method
    // with that common block of code, and call this private method in those default methods.
}
