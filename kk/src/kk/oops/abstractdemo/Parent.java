package kk.oops.abstractdemo;

public abstract class Parent {
    int age;    // Since this is still an abstract class, hence this class cannot have objects, unless methods are override while creating the objects.
        // Therefore, variables are not bound to be final static. Variable can be final, static, final static, or without any of them.
    final int VALUE;
    // the constructor cannot create objects, but can be used to initialize the instance variables and perform some task. Below is best example
    // This class cannot create objects, but its child classes can call this parent constructor to initialize the variables of this class which are instance variables of child inherently
    public Parent(int age, int value) {
        this.age = age;
        this.VALUE = value;
    }

//    abstract Parent();  // needs some functionality when object gets created, hence its giving error.

    abstract void career(String job);
    abstract void partner(String name, int age);

    static void greeting() {
        System.out.println("Hello from Parent.");
    }

    // Abstract class can contain normal methods. Normal methods can be overridden also
    void normal() {
        System.out.println("This is normal method from Parent");
    }
}
