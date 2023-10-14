package kk.functions;

import java.util.Arrays;

public class VarArgs {
    // varargs if present with keyword args, then varargs will be at last in the params
    public static void main(String[] args) {
        fun1(2, 3, 4, 6);
        fun1();
        fun2(2, "3", 4, 5, 6);
        fun2(8, "7");
    }

    static void fun1(int... varArgs) {
        // Multiple args passed individually but received in varArgs in Arrays data type
        System.out.println(Arrays.toString(varArgs));
    }

    // Overloading and varArgs:  If below method is uncommented, then due to its overloading,
    // its empty call cannot be resolved
//    static void fun1(String ...varArgs) {
//        System.out.println(Arrays.toString(varArgs));
//    }

    static void fun2(int a, String b, int ...varArgs) {
        System.out.println(Arrays.toString(varArgs));
    }
}
