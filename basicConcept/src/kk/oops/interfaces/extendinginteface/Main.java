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

    static void stat1() {
        System.out.println("Main: Static methods in interface must have body");
    }


    public static void main(String[] args) {
        Main obj = new Main();
        // Below line will throw an error in cases where stat1() is not defined here or in upstream parent classes of this class(which is not case here); error because static method are inherited from classes but not from interfaces.
        obj.stat1();    // "cannot" refer static method of interface using object reference in cases where static method is not overridden in classes of type <? super thisclass> because it is not inherited or shadowed,
        // because class can only be inherited not interfaces.
        // Use interface reference to call static method defined in them.
//        obj.stat2();  // error scenario, as LHS obj is of child type which is taken into consideration while calling any static entity of the class,
//        and here in this class, there is no anystat1() method particularly belonging to this class.
        A.stat1();
//        B.stat1();    // Even B also cannot call static method of A even though B extends A. Reason is, B doesn't extend A as if A is class. A is not class but interface.
                        // So static method of A is not inherited in B and its downstream inheritance.
//        Main.stat2(); // Static methods of interfaces are not inherited outside of that interface, and can be accessed only class reference inti which they are defined.
        B.stat2();
    }
}
