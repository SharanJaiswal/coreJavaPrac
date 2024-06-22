package kk.oops.interfaces.deafultinterface;

public interface A {
    default void fun() {    // from java 8 onwards we can give default implementation to interface
        System.out.println("I am in A");
    }

    // default methods in interfaces are always public. "default" method are added in Java-8 to extend functionality in legacy interfaces.
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
    default public void forConflict() {    // See interface B for its description
        System.out.println("Conflict picked from A");
    }

    default public void makeAbstract() {
        System.out.println("this have body");
    }
}

interface C extends A {
    abstract public void makeAbstract();    // we can make default method from parent interfaces again abstract.
}

interface D extends A {
    @Override
    default public void makeAbstract () {   // since we are in an interface, hence we use "default" keyword to override the default method. But it is still overridden.
        A.super.makeAbstract(); // since if default is called by the object of the class implementing it, so we used "super" as this used in context with objects. Otherwise, it can be called anywhere using interface reference based on its accessibility.

    }
}