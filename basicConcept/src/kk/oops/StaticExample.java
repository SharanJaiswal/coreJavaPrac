package kk.oops;

public class StaticExample {
    public static void main(String[] args) {
        // main is a static method
        // Consider this main methods as part of code in application that will anywhere create the object of this class.
        // From static method, to call non-static methods, we need an object to refer those non-static methods via objects.
        StaticExample obj = new StaticExample();
        obj.nonStatic();

        // To call static methods from static methods, we don't need class objects. We can refer them using class itself.
        // Although we can call the static method using "this" keyword, but it is not acceptable and will give error, and doesn't make clear sense to the logic.
        // So avoid using "this" to refer the static candidates.
        StaticExample.fun();
        fun();  // We can and cannot use class name as a reference to access the static method. If we are not using, then that static member must belong to same class.
//        this.fun();   // Using "this" keyword will give an error because static members are object independent

        obj.fun();  // This will work because static members are accessible by objects. But is not preferred way to access static members of a class
        System.out.println(StaticExample.number);
//        System.out.println(this.number);  // Using "this" keyword will give an error because static members are object independent
        System.out.println(obj.number); // avoid accessing static members using object references.
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
        fun();  // We can and cannot use class name as a reference to access the static method. If we are not using, then that static member must belong to same class.
    }
}
