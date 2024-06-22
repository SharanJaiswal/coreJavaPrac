package kk.oops.interfaces.deafultinterface;

public class Driver implements A, B {
    // If we want to call different body of default method with same signature.
    // Actually, the default method is inherited, and can be overridden.
    // If we override method with same signature in class which implements interface having same signature default method,
    // then it hides the scope of the inherited default interface method in this class.
    // On precedence, the overridden body of method of this class will be executed.
    @Override
    public void fun() {
        System.out.println("Fun in driver");
    }

    @Override
    public void greet() {
        System.out.println("greet in driver");
    }

    // If there are 2 defaults inherited with same method signature, then override it and
    // provide the body as which method's body to execute; A's or B's. We can also add out code in below method
    @Override
    public void forConflict() { // since we are in a class, hence we didn't use "default" keyword to override the default method. But it is still overridden.
        A.super.forConflict();
//        B.super.forConflict();
        System.out.println("Conflict resolved");
    }

    public static void main(String[] args) {
        Driver obj1 = new Driver();
        obj1.fun();
        obj1.greet();
        obj1.seeoff();
        obj1.forConflict();
    }
}
