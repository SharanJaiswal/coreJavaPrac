package kk.oops.inheritance;

public class Box {
//    private double l; // If any attribute is private in parent class, it cannot be directly referenced from the objects of Parent or Child class.
// There has to be some way in the same class where private attribute is defined and initialized through which it can be referenced.
    double l;
    double h;
    double w;
    int commonName;

    public Box() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    public Box(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    public Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    public Box(Box old) {
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
    }

    public void information() {
        System.out.println("Running the Box");
        // Here we can directly access any private variable of this class. But if this method is overriden in child class, then same variable of this class won't be
        // accessible form that overriding child class method, even when direct attempt is made using super.
        // This class private members can be accessed via calling this class' allowed members only, ie, from child class inside overriding method, we can access private members via super.information();
    }

    /**
     * If we are overriding a method in a child class and suppose there is another method with the same method name,
     * same method arguments, but have different return type, then error will be thrown.
     * It is because, when we call the method, we mention its name and it parameters with its type.
     * If these both, name and param type and count will be same, then calling place won't be able to distinguish at compile time to link which method.
     * * Another method in child with same signature of parent class' method but without @Override annotation and different return type gives error because @Override annotation is not necessary.
     * Also, whenever we use @Override annotation over overriding method in child class, compiler makes sure that there is actually a method in parent class
     * with same method name, same param count, each param type in same order, and same return type, otherwise it'll throw an error.
     */
}
