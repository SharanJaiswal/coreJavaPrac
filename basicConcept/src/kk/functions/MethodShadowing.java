package kk.functions;

import java.util.Scanner;

public class MethodShadowing {
    static int x = 90;  // For shadowing
    int y = 90;
    public static void main(String[] args) {
        String outer = "Sharan";
        {   // any reference variable declared inside a block, will have its scope till that block. A block is " { . . . } "
            String inner = "Jaiswal";
            outer = inner;
            // both same as writing outer=inner;

            System.out.println(outer);
        }
        System.out.println(outer);

        // For shadowing continued... here it is shadowing the variable "x" in the main method enclosing scope
        int x;
        x = 80; // scope will begin when value is initialized
        System.out.println(x);  // Since, name is same; hence, it is called name-masking

        // For shadowing also
        sum();  // Although call is in scope where shadowing var is initialized, but the actual method is out of scope.
                // The scope of the called method is out of the shadowing scope, hence will access the shadowed var val.

        MethodShadowing obj1 = new MethodShadowing();
        FirstLevel firstLevel = obj1.new FirstLevel();  // We can also write type of reference variable as "MethodShadowing.FirstLevel"
        firstLevel.printNum(56);
    }

    /**
     * Inner class can access parent class members including private members, but parent class cannot access directly members of inner class. Inner class can be declared static also. Inner class can have access-modifier.
     * Nested inner class cannot exist independently of outer-class. Nested class is also a member of outer class. Although, nested class can be static, but its object can be made and instantiated.
     * A static nested class cannot directly access instance members of the enclosing class, but can access only static members of the enclosing class.
     */
    class FirstLevel {
        int x = 34;
        public void printNum(int x) {
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(MethodShadowing.this.x); // Here, in case where x in MethodShadowing scope is defined as static variable, we can also access that x as MethodShadowing.x.
            // If that x is not static, then we will access by this way only.

            // We can make outer class's object inside the inner class.
            MethodShadowing obj3 = new MethodShadowing();
            System.out.println(obj3.y);
        }

        // Although we can define the static main method inside normal inner nested class, but the body of it will not shadow the body of enclosing main class. Hence, even if we run this main method(),
//        the body of main method of enclosing class will get executed. This class is dependent on the object of the outer class.
        public static void main(String[] args) {
            System.out.println("Inside the FirstLevel normal inner class.");
        }
    }

    // This class does not depend on the object tof the outer class.
    static class StaticNestedClass {
        // Its main body will run if we try to access and invoke this class main method directly from terminal, which is opposite of the case with normal inner nested classes.
        public static void main(String[] args) {
            System.out.println("Inside the FirstLevel static inner class.");
        }
    }

    static void sum() {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int sum = num1 + num2;
        System.out.println("Sum is : " + sum);

        // For shadowing
        System.out.println(x);
    }
}
