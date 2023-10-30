package kk.oops.finalclassandmethods;

public class Container {
    int size;
    String material;

    public Container(int size, String material) {
        this.size = size;
        this.material = material;
    }

    public Container() {
    }

    // This method can be overridden because it is not final method, and neither this class is not defined as final class
    void getSizeAndMaterial() {
        System.out.println(this.size + " " + this.material);
    }

    // This method cannot be overridden as this method is defined as final method
    final void getCostPrice() {
        System.out.println("Cost Price : " + this.size * 10);
    }


    // Now lets see if the static methods can be inherited or not
    static void greetings() {
        System.out.println("Hi I am in Container method. Greetings!!");
    }

//    Final static methods can be inherited but cannot be overridden. On contrary normal static methods can be inherited, overridden, but overridden body don't gets executed
}
