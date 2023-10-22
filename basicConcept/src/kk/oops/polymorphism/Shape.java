package kk.oops.polymorphism;

public class Shape {
    void area() {
        System.out.println("I am in Shape.");
    }

    final void finalMethod() {
        System.out.println("This method cannot be overridden");
    }
}
