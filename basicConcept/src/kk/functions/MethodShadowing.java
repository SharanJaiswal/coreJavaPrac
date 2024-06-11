package kk.functions;

import java.util.Scanner;

public class MethodShadowing {
    static int x = 90;  // For shadowing
    int y = 90;
    private String str = "private parent string";
    public static void main(String[] args) {
        String outer = "Sharan";
        {   // any reference variable declared inside a block, will have its scope till that block. A block is " { . . . } "
            String inner = "Jaiswal";
            outer = inner;
            // both same as writing outer=inner;

            System.out.println(outer);  // Jaiswal

//            String outer = "Saint";    // we cannot declare a same variable if it is already accessible in a same access-level-scope(class or object or method), even if it is accessible here from its parent scope.
        }
        System.out.println(outer);  // Jaiswal

        // we can declare variables again in lower scope which are declared in the higher scope.
        // For shadowing continued... here it is shadowing the variable "x" in the main method enclosing scope
        int x;
        x = 80; // scope will begin when value is initialized
        System.out.println(x);  // 80 - Since, name is same; hence, it is called name-masking
        int y = 100;
        String str = "method level string";
        System.out.println(y);
        System.out.println(str);

        // For shadowing also
        sum();  // Although call is in scope where shadowing var is initialized, but the actual method is out of scope.
                // The scope of the called method is out of the shadowing scope, hence will access the shadowed var val.

        MethodShadowing obj1 = new MethodShadowing();
        FirstLevel firstLevel = obj1.new FirstLevel();  // We can also write type of reference variable as "MethodShadowing.FirstLevel" which is recommended.
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
            System.out.println(x);  // 56
            System.out.println(this.x); // 34
            System.out.println(FirstLevel.this.x);  // 34 - I'm assuming that when we are explicitly mentioning classname before "this", then this(obj) makes only that class specific entities. Hence, I think, this might the reason.
            System.out.println(MethodShadowing.this.x); // 90 - Here, in case where x in MethodShadowing scope is defined as static variable, we can also access that x as MethodShadowing.x.
            // If that x is not static, then we will access by this way only.
//            System.out.println(super.x);  // this is wrong as super is used in context of inheritance. This context is related to nested class.

            // We can make outer class's object inside the inner class.
            MethodShadowing obj3 = new MethodShadowing();
            System.out.println(obj3.y); // 90
            System.out.println(obj3.str);   // "private parent string"
        }

        // Although we can define the static main method inside normal inner nested class, but the body of it will not shadow the body of enclosing main class. Hence, even if we run this main method(),
//        the body of main method of enclosing class will get executed. This class is dependent on the object of the outer class.
        public static void main(String[] args) {
            System.out.println("Inside the FirstLevel normal inner class.");
        }
    }

    // This class does not depend on the object of the outer class.
    static class StaticNestedClass {
        // Its main body will run if we try to access and invoke this class main method directly from terminal, which is opposite of the case with normal inner nested classes.
        public static void main(String[] args) {
            System.out.println("Inside the FirstLevel static inner class.");
        }
    }

    static void sum() {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(); // 14
        int num2 = input.nextInt(); // 15
        int sum = num1 + num2;
        System.out.println("Sum is : " + sum);  // 29

        // For shadowing
        System.out.println(x);  // 90
    }
}
