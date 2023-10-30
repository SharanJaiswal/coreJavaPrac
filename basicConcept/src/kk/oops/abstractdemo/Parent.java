package kk.oops.abstractdemo;

public abstract class Parent {
    int age;    // Since this is still an abstract class, hence this class cannot have objects, unless methods are override while creating the objects.
        // Therefore, variables & methods are not bound to be final static. They can be final, static, final static, or without any of them.
    final int VALUE;
    // the constructor cannot create objects, but can be used to initialize the instance variables and perform some task. Below is best example
    // This class cannot create objects unless abstract methods will have body,
    // but its child classes can call this parent constructor to initialize the variables of this class which are instance variables of child inherently
    public Parent(int age, int value) {
        this.age = age;
        this.VALUE = value;
    }

//    abstract Parent();  // needs some functionality when object gets created, hence its giving error.


    // Below methods are not explicitly public. It's access modifier can be of any type. Because abstract class can have methods that are non-abstract.
    // These abstract methods can be called inside from any method with body of this class if we provide the body to it at place where we call it.
    // In case where we want to restrict this abstract method not to get defined in extending classes, we can put "private" to these abstract methods.
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
