package kk.oops.interfaces;

public interface Engine {
    public static final int PRICE = 78000;  // This is how constants get defined in java
    // Only difference between variables of abstract class and an interface is that abstract class variables can be of any access modifier type, but interface's must be of public.
    // By default, interface's variables is of type "public static final" and is only allowed type. It's redundant to explicitly mention it again before interface variable name.
    // public: because it need to be accessed from the implementing classes, and directly using interface reference.
    // static: because it cannot be accessed from the object of interface, as creating object of interface is not allowed.
    // final: because interface by design is template that needs to be used invariably by the classes that implements it. Hence, the value should be same everywhere.
    // Since interface cannot have constructor, therefore the variable of interface must be initialized at its definition.

    // Interface Methods CANNOT have final in any form, ie, final static or final because final methods needs body, but interfaces cannot have instance methods with body.
    // Interface methods can be static provided with body because static methods does not depend on the object of interface as interfaces don't have objects.
    // If they are not static, they must not have body. If static keyword is allowed, then calling interface method must require body via interface name.
    // Interfaces cannot have normal instance methods as they need object to access them.

    // Even Media interface has start and stop method. So class that inherits both, it's not specific from which start/stop its inherited
    public abstract void start();   // Methods other than static methods in interface are by default abstract. Also, public because of the reason stated above.
    void stop();
    void acc();

    static void staticMethod () {
        System.out.println("static method");
    }

    // Interfaces can also have private methods. Since interfaces don't have any instances, hence private methods can be called from within the class itself. Therefore, these private
    // methods can be called either via static methods, or by default methods. Any class that will be implementing that interface, cannot access this private method because it is private.
    private void interfacePrivateMethod() {
        System.out.println("Executing private method in interface.");
    }
    // However, variables cannot be of type private, protected, or package-private. It can only be of type public static final.
    // Also, all variables declared will have "public static final" type. Adding custom access-modifier will create ambiguity and hence error.
}
