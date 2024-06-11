package kk.oops.finalclassandmethods;

public class Container {
    int size;   // instance
    String material;    // instance
    static String staticVar;    // class
    static String anotherStaticVar; // class

    // Below for 2 final types variables, we have to provide their instantiation always.
    final String finalVar = "Container Final Variable"; // instance
    final static String finalStaticVar = "Container Final Static Variable"; // class

    public Container(int size, String material) {
        this.size = size;
        this.material = material;
    }

    public Container() {
    }

    // This instance method can be inherited and overridden because it is not final method, and neither this class is not defined as final class
    void getSizeAndMaterial() {
        System.out.println("In conatiner " + this.size + " " + this.material);
    }

    // This method can be inherited but cannot be overridden as this method is defined as final method, hence we cannot change its content/body in child class
    final void getCostPrice() {
        System.out.println("Cost Price : " + this.size * 10);
    }


    // Now lets see if the static methods can be inherited or not.
    // See explanation in StaticMethodInherit class file
    static void greetings() {
        System.out.println("Hi I am in Container method. Greetings!!");
    }

    static void anotherStaticMethod() {
        System.out.println("Another non-derived static method.");
    }

//    Final static methods can be inherited but cannot be overridden.
}
