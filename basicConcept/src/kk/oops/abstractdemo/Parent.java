package kk.oops.abstractdemo;

public abstract class Parent {
    // Variables of any type of abstract class can have any type of access-modifiers
    int age;    // Since this is still an abstract class, hence this class cannot have objects, unless methods are overridden before creating the objects.
        // Therefore, methods with body defined and variables are NOT bound to be final static. They CAN be final, static, final static, or without any of them.
    final int VALUE;    // Abstract class can have final variable.

    static String staticVar = "Static variable in abstract class."; // abstract class can have static variable.
    final static String finalStaticVariable = "Final Static Variable in abstract class.";   // Abstract class can have final static variable.
    // the constructor cannot create objects, but can be used to initialize the instance variables and perform some task. Below is best example
    // This class cannot create objects unless abstract methods will have body,
    // but its child classes can call this parent constructor to initialize the variables of this class which are instance variables of child inherently
    public Parent(int age, int value) {
        this.age = age;
        this.VALUE = value;
    }

    // Constructor cannot be abstract because it should have body/functionality even though body can be empty but should have body part {}
//    abstract Parent();  // needs some functionality when object gets created, hence its giving error.


    // Below methods with body are not explicitly public. It's access modifier can be of any type. Because abstract class can have methods that are non-abstract.
    // These abstract methods can be called inside from any class' method with body, of this class, if we provide the body to it at place where we call it.
    // We CANNOT put "private" to these abstract methods because first its illegal combination,
    // and second, if we make it private, how can we inherit into other classes for the sole purpose of overriding it?
    // Also, if abstract methods are to be overridden in the child classes, then access modifier can be either same or less-restrictive|stronger-privilege
    // Abstract methods cannot be final because final methods must have body which cannot be changed in child class.
    // Abstract class can have final methods.
    abstract void career(String job);
    abstract void partner(String name, int age);

    static void greeting() {
        System.out.println("Hello from Parent.");
    }

    // Abstract class can contain normal methods. Normal methods can be overridden also
    void normal() {
        System.out.println("This is normal method from Parent");
    }

    final void finalMethodInAbstract() {
        System.out.println("Executing final method From abstract class.");
    }

    static final void finalStaticMethod() {
        System.out.println("Executing static final method from abstract class.");
    }
}
