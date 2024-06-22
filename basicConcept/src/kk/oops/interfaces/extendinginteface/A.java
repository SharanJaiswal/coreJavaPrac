package kk.oops.interfaces.extendinginteface;

//public interface A extends sampleClass1{  // interfaces cannot extend classes, be it abstract class.
public interface A {
    // static interfaces can be of any access modifier from java 9, before only public till 8. These static methods can be called anywhere using interface reference based on its accessibility.
    static void stat1() {
        System.out.println("A: Static methods in interface must have body");
    }
    void fun();
}

abstract class sampleClass1 {}