package kk.oops;

public class StaticExample {
    public static void main(String[] args) {
        // main is a static method
        // Consider this main methods as part of code in application that will anywhere create the object this class.
        // From static method, to call non-static methods, we need an object to refer those non-static methods via objects.
        StaticExample obj = new StaticExample();
        obj.nonStatic();

        // TO call static methods from static methods, we don't need class objects. We can refer them using class itself.
        // Although we can call the static method using "this" keyword, but it is not acceptable, and doesn't make clear sense to the logic.
        // So avoid using "this" to refer the static candidates.
        StaticExample.fun();
        System.out.println(StaticExample.number);
    }
    static int number;  // Unlike final variables, static variables don't need to initialize themselves. They will follow default value.
    static void fun() {
//            greetings();    // cannot use greetings directly without referencing it with objects.
        // Since we are inside static method, we cannot use "this" keyword also because this static method is called by referencing class itself.
//        this.greetings();

        // To call the non-static candidates inside the static method, we need object. Hence, we will create it.
        StaticExample obj1 = new StaticExample();
        obj1.greetings();
    }

    void greetings() {
        System.out.println("From greetings!!!");
    }

    void nonStatic() {
        System.out.println("Inside non static method!!!");
        greetings();    // aka, this.greetings(); ,ie, nonStatic() is non-static method, and can call other object dependent objects, to which object it is part of.
    }
}
