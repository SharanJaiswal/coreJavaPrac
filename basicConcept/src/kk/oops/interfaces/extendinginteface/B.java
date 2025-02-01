package kk.oops.interfaces.extendinginteface;

public interface B extends A {  // interface to interface inheritance uses "extends" keyword.
    void greet();

    /**
     * Even though A gets extended here in interface, we have a choice to not provide body to interface bodyless methods.
     * Although, that bodyless method got inherited. So, now when B will get implemented, will have body defined for all such bodyless methods.
     */

    static void stat2() {
        System.out.println("B: Static methods in interface must have body");
    }
}
