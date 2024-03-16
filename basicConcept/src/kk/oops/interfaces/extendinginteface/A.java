package kk.oops.interfaces.extendinginteface;

public interface A {

    static void stat1() {
        System.out.println("A: Static methods in interface must have body");
    }
    void fun();
}
