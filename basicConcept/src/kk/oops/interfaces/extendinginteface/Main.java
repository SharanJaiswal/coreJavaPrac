package kk.oops.interfaces.extendinginteface;

public class Main implements B {    // interface to class inheritance uses "implements" keyword
    /*
    If such interface is implemented which is inheriting another interface, then while implementing such interfaces,
    all the abstract methods must be inherited and overridden in a class.
     */
    @Override
    public void fun() {

    }

    @Override
    public void greet() {

    }

    public static void main(String[] args) {
        Main obj = new Main();
//        obj.stat1();    // cannot refer static method of interface using object reference at all because it is not inherited, because class can only be inherited not interfaces
        // Use interface reference to call static method defined in them
        A.stat1();
//        B.stat1();    // Even B also cannot call static method of A even though B extends A. Reason is, B doesn't extend A as if A is class. A is not class but interface.
                        // So static method of A is not inherited in B and its downstream inheritance.
//        Main.stat2(); // Static methods of interfaces are not inherited outside of that interface, and can be accessed only class reference inti which they are defined.
        B.stat2();
    }
}
