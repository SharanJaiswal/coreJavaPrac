package kk.functions;

import java.util.Scanner;

public class MethodShadowing {
    static int x = 90;  // For shadowing
    int y = 90;
    private String str = "private parent string";

    public static void main(String[] args) {    // Although methods are part of class, but consider them as the loosly wired with class, not actually the inseparable part of class. Hence, we can declare variables with same name here as it is in class level.
        // we can declare variables again in nested scope which are declared in the parent scope, provided the nested scope|block has some label to identify, eg class methods; not simply blocks.
        // For shadowing continued... here it is shadowing the variable "x" in the main method enclosing scope
        // Testing below 3 which are same as above-mentioned 3 at class level

//        static int x = 90;  // Cannot define/declare anything static inside a class method, be it same variable or new different variable name.
        int x;
        x = 80; // scope will begin when value is initialized
        System.out.println(x);  // 80 - Since, name is same; hence, it is called name-masking
        int y = 100;
        System.out.println(y);  // 100

//        private String str = "private parent string";   // Cannot define/declare anything private inside class method, be it same name or new different variable name.
        String str = "method local string";
        System.out.println(str);    // method local string

        String outer = "Sharan";
        {   // any reference variable declared inside a block, will have its scope till that block. A block is " { . . . } " . Consider the blocks are the inseparable part of the enclosing entity, here a method. Hence, we cannot redeclare variable with same name as in enclosing scope.
            String inner = "Jaiswal";
//            String outer;   // "outer" is already defined and present in this scope, hence can't be redefined; because this block scope is not labelled which is tightly coupled with the method.
            outer = inner;
            // both same as writing outer=inner;

            System.out.println(outer);  // Jaiswal

//            String outer = "Saint";    // we cannot declare a same variable if it is already accessible in a same access-level-scope(class or object or method), even if it is accessible here from its parent scope. Same goes for 'x' and 'y'.
        }
        System.out.println(outer);  // Jaiswal

        // For shadowing also
        sum();  // Although call is in scope where shadowing var is initialized, but the actual method is out of scope.
                // The scope of the called method is out of the shadowing scope, hence will access the shadowed var val.

        MethodShadowing obj1 = new MethodShadowing();
        FirstLevel firstLevel = obj1.new FirstLevel();  // We can also write type of reference variable as "MethodShadowing.FirstLevel" which is recommended.
        firstLevel.printNum(56);
        firstLevel.main(null);
    }

    /**
     * Inner class can access parent class members including private members, but parent class cannot access directly members of inner class. Inner class can be declared static also. Inner class can have access-modifier.
     * Nested inner class cannot exist independently of outer-class. Nested class is also a member of outer class. Although, nested class can be static, but its object can be made and instantiated.
     * A static nested class cannot directly access instance members of the enclosing class, but can access only static members of the enclosing class.
     */
    class FirstLevel {
        int x = 34;
        int y;
        public void printNum(int x) {
            System.out.println(x);  // 56
            System.out.println(this.x); // 34
            System.out.println(FirstLevel.this.x);  // 34 - I'm assuming that when we are explicitly mentioning classname before "this", then this(obj) makes only that class specific entities. Hence, I think, this might the reason.
            System.out.println(MethodShadowing.this.x); // 90 - Here, in case where x in MethodShadowing scope is defined as static variable, we can also access that x as MethodShadowing.x.
            // If that x is not static, then we will access by this way only.
            System.out.println(MethodShadowing.x);  // 90
//            System.out.println(super.x);  // this is wrong as super is used in context of inheritance. This context is related to nested class.
            System.out.println(MethodShadowing.this.y); // 90
            System.out.println(y);  // 0 - this.y, FirstLevel.this.y
//            System.out.println(MethodShadowing.y);  // This won't work as y is not static member of MethodShadowding class. "y" is instance member variable of MethodShadowing class, hence needs object of MethodShadowing above. Also, enclosing class cannot access nested class members.
            System.out.println(str);    // "private parent string"
            System.out.println(MethodShadowing.this.str);   // "private parent string"
            // Both below will throw an exception, as we are explicitly asking to give the FirstLevel's version of string, which is not present
            // Above 2 lines makes us understand that just accessing variable "str" will first internally resolve at FirstLevel's level method scope, then class variable "str". When not found then FirstLevel's static scope, and then at last in the enclosing scope.
//            System.out.println(this.str);
//            System.out.println(FirstLevel.this.str);

            // We can make outer class's object inside the inner class.
            MethodShadowing obj3 = new MethodShadowing();
            System.out.println(obj3.y); // 90
            System.out.println(obj3.str);   // "private parent string"

            // We can access sibling nested class
            MethodShadowing.StaticNestedClass staticNestedClass = new MethodShadowing.StaticNestedClass();
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
        System.out.println(x);  // 90 - This will read value of x from either from its scope, or from its parent's scope. Hence, it's not getting affected by the change in the value of x inside main method, as this method is main method's sibling (same level)
    }
}
