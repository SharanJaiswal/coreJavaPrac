package kk.oops.interfaces.extendinginteface;

public interface A {

    static void stat1() {
        System.out.println("A: Static methods in interface must have body");
    }
    void fun();

    // Interfaces can also have private methods. Since interfaces don't have any instances, hence private methods can be called from within the class itself. Therefore, these private
    // methods can be called either via static methods, or by default methods. Any class that will be implementing that interface, cannot access this private method because it is private.
}
