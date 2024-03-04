package kk.oops.finalclassandmethods;

public class Container {
    int size;
    String material;
    static String staticVar;

    // Below for 2 final types variables, we have to provide their instantiation always.
    final String finalVar = "Container Final Variable";
    final static String finalStaticVar = "Container Final Static Variable";

    public Container(int size, String material) {
        this.size = size;
        this.material = material;
    }

    public Container() {
    }

    // This method can be overridden because it is not final method, and neither this class is not defined as final class
    void getSizeAndMaterial() {
        System.out.println("In conatiner " + this.size + " " + this.material);
    }

    // This method can be inherited but cannot be overridden as this method is defined as final method, hence we cannot change its content/body
    final void getCostPrice() {
        System.out.println("Cost Price : " + this.size * 10);
    }


    // Now lets see if the static methods can be inherited or not.
    // See explanation in Container class file
    static void greetings() {
        System.out.println("Hi I am in Container method. Greetings!!");
    }

    static void anotherStaticMethod() {
        System.out.println("Another non-derived static method.");
    }

//    Final static methods can be inherited but cannot be overridden. On contrary normal static methods can be inherited, overridden, but overridden body don't get executed
}
