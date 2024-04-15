package kk.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class strings {
    public static void main(String[] args) {
        String a = null;    // String ref var pointing to null will print "null" as string in output, not "". Also, toString on null is a string object having value "null".
        System.out.println("strings.main");
        System.out.println("args = " + Arrays.toString(args));
//        System.out.println(null);   // this will give error because println could not able to decide whether the null is of type String or char[] or any data type that can have null.
        System.out.println("a = " + a + null);  // while this works because before null which acts as the second operand to second '+' operator, its first operand is of String type.
        // above it is decided that last operand null is related to String type
        System.out.println(null + "AAAA");  // So, either of the operand for binary operator must be String, if another is null. So that null is promoted to String type.
        System.out.println(a);

        /*
        Operators behavior on the data types: Custom operator-loading is not supported in java.
        Operator '+' is defined in java when operands are primitives and overloaded when at least one of the operand is String type among first 2 operands. It can be allowed to be used with complex data type as well;
        but only if at least one of the operand among first 2 operands is of type String. Hence, the entire arg passed to println becomes of type new String Object of concatenated Strings. '+' is only operator which is overloaded internally by java.
        So, if one param is passed to println, better it has its toString() defined. If more than 2 params are operated using '+', better either of first 2 operand is String. or, all the operands are combinations of characters and integers.
        Strictly, it follows the combined rules of operator precedence order of execution and fact that one of the operand must be of type String if all the operands for a given '+' operator is not of primitive type.
        So, If either of 2 operands is of type String, then, other operand's valueOf() method is first called. Hence, unless those 2 operands' value becomes of type String and then concatenated, String_op1+String_op2 doesn't happen,
        which internally calls valueOf->"null"|toString. Although, re-iterating that, this logic only works if both the operand are not primitive type, and at least one operand is of type String.
         */
        System.out.println('a' + 'b');  // 97+98
        System.out.println("a" + 5);    // Ctrl+Click on println opens method that just takes single argument of type String. Hence, proved; first, valueOf() of operand of type other than String is called, then concatenation happens, then gain vlaueOf(cnct_str) is called.
        System.out.println(5 + "a");
        System.out.println('a' + 5);
        System.out.println(5 + 5 + 'a');
        System.out.println(5 + 5 + "a");
//        System.out.println(5 + new int[] {1,2,3,4,5});// Error even if operands are interchanged because since all operands are not of primitive types. Also, neither of the first two operands are of type String. One is of type "Array" used with "int"
        System.out.println(new int[] {1,2,3,4,5});  // SAYS makes implicit call to Arrays.toString(new int[]{1, 2, 3, 4, 5}) but prints the valueOf, output is different if called like below.
        // It is because valueOf method calls toString method if it is present. If toString method is not present, then some random characters are printed, e.g., "[I@7834w5t438"
        // It is because, there is a difference between "Array" and "Arrays" and "ArrayList". Here, we've Array, a sequence of allocated memory, here of primitive data types., w/o toString method.
        // While Arrays is derive data type, with toString method overriden|defined into Arrays class.
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4, 5}));
        System.out.println("a" + new int[] {1,2,3,4,5});
        System.out.println("" + 5 + new int[] {1,2,3,4,5});
        System.out.println(new int[] {} + "a");
        System.out.println("a" + new ArrayList<>());
        System.out.println(new ArrayList<>() + "b");
        System.out.println(new ArrayList<>());
        System.out.println((char)('a' + 5));
//        System.out.println(new ArrayList<>() + new int[] {}); // Error even if operands are interchanged. Because, first '+' operator works, then println which converts passed val to String and then prints it.
//        So, '+' doesn't know to implicitly convert the operand value to String, and hence to concatenate their string values as a single string.
        System.out.println("" + new int[] {} + "" + new ArrayList<>());  // At least one is of type String among first 2 operands. Here, either of the
//        System.out.println(new Integer(56) + new ArrayList<>());  // Among first 2, nothing is String or primitive data type
        System.out.println(new Integer(56) + "" + new ArrayList<>());
        System.out.println(Integer.valueOf(56) + "" + new ArrayList<>());

        /*
        String has many methods for its objects
         */
        String name = "Sharan Jaiswal";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase()); // new object is created with all things in lower case
        System.out.println(name);   // original object doesn't get changed
        System.out.println(Arrays.toString(name.split(" ")));   // split needs a regex and returns a String[] array
        System.out.println(Arrays.toString("boo:and:foo".split("o")));  // It should have one "" empty-sting more as on output, derived from last "oo" of "foo".

        // Replacing all whitespaces
        String white = "sljdbdvc j qfjv vx aj ljda ald   cl la  kac c a   k lda lma lm lc  ";
        System.out.println(white.replaceAll("\\s", ""));
    }
}
