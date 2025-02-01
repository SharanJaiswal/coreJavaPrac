package kk.functions;

import java.util.Arrays;

public class VarArgs {
    // var-args if present with keyword args, then var-args will be at last in the params
    public static void main(String[] args) {
        fun1(2, 3, 4, 6);   // [2, 3, 4, 6]
        fun1(); // []
        fun1(2, "3", 4, 5, 6);  // [4, 5, 6]
        fun1(8, "7");   // []
    }

    // Only 1 varArgs should be present as a method argument, and that too as the last argument.

    static void fun1(int... varArgs) {
        // Multiple args passed individually but received in varArgs in Array data type
        System.out.println(Arrays.toString(varArgs));
    }

    // A method is overloaded when there are different permutations of arguments, considering also its arguments type; not by the return type.
//    static int fun1(int... varArgs) {
//        // Multiple args passed individually but received in varArgs in Array data type
//        System.out.println(Arrays.toString(varArgs));   // [2, 3, 4, 6]
//        return 0;
//    }

    // Overloading and varArgs:  If below method is uncommented, then due to its overloading,
    // its empty call cannot be resolved at compile time. Moreover, error will not be here, but at a place from where fun1() is being called, because at there, compiler won't be able to resolve linkage.
//    static void fun1(String ...varArgs) {
//        System.out.println(Arrays.toString(varArgs));
//    }

    static void fun1(int a, String b, int ...varArgs) {
        System.out.println(Arrays.toString(varArgs));
    }

    // Same name but different signature
    static void fun1(String a, int... varArgs) {
        System.out.println(Arrays.toString(varArgs));
    }
    // Similarly, although we can define function fun1(String str, int i) {sout(vargs);}  but if we call fun1("a", 8); then compiler won't be able to resolve the version of fun1() to call

    // Classes may or may not be holding generic placeholder in their signature. But their constructors can, irrespective of the former case.
    // Methods can also be overloaded with parameterized type difference where one can hold generic & other can be specific
    static <T extends Character> void fun1(T a, int... varArgs) {   // If, fun1 is called with first param being Character type, and other being varArgs of integers. Hence, if first param passed is of String type, then just above method will be called, else if this if char is passed.
        System.out.println(Arrays.toString(varArgs));
    }
}
