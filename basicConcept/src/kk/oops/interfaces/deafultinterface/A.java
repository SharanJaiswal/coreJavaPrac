package kk.oops.interfaces.deafultinterface;

public interface A {
    default void fun() {    // from java 8 onwards we can give default implementation to interface
        System.out.println("I am in A");
    }

    /*
    In real world, once interface gets published, its out there to use and implement, and override abstract methods.
    We cannot simply add one more abstract method in the interface which is being implemented by many.
    If we do so, in that case it will require every numerous implementation of it to override newly added abstract method.
    Until then, code will be broken.
    So primary motivation is to expand interfaces without breaking the code, in cases where
    the body defined in all the classes that implements the interface is same. One change which is required in
    functionality of that interface method, requires developer to change its overridden body in all the classes
    which implemented it. So, default saves time. Change it here and it will reflect everywhere.
    Static methods in interface cannot be inherited but default methods can be inherited. Also, default methods can be overridden.
     */
    default void forConflict() {    // See interface B for its description
        System.out.println("Conflict picked from A");
    }
}
