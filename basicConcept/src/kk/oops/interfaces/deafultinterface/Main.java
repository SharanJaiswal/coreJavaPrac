package kk.oops.interfaces.deafultinterface;

public class Main implements A, B {
    // Even though there is abstract method in interface A which is not overridden here, it's okay
    @Override
    public void greet() {
        System.out.println("Greetings!!!");
    }

    @Override
    public void seeoff() {
//        B.super.seeoff();
        System.out.println("Overriding the seeoff default method of interface in class where it is implemented.");
    }

    public static void main(String[] args) {
        Main obj1 = new Main();
        obj1.fun();
        obj1.greet();
        obj1.seeoff();
        obj1.forConflict();
    }

    // See Drive class for the below method's description and logic
    @Override
    public void forConflict() {
//        A.super.forConflict();
        B.super.forConflict();

    }
}
