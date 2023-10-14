package kk.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class strings {
    public static void main(String[] args) {
        String a = null;    // String ref var pointing to null will print "null" as string in output, not ""
        System.out.println("strings.main");
        System.out.println("args = " + Arrays.toString(args));
        System.out.println("a = " + a);


        /*
        Operators behavior on the data types: Custom operator loading is not supported.
        Operator '+' is defined in java for only when operands are primitives
        or when at least one of the operand is String type among first 2 operands.
        It cna be allowed to be used with complex data type as well;
        but only if at least one of the operand among first 2 operands is of type String.
        Hence, the entire arg passed to println becomes of type new String Object of concatenated Strings.
        '+' is only operator which is overloaded internally by java.
         */
        System.out.println('a' + 'b');
        System.out.println("a" + 5);
        System.out.println(5 + "a");
        System.out.println('a' + 5);
        System.out.println(5 + 5 + 'a');
        System.out.println(5 + 5 + "a");
//        System.out.println(5 + new int[] {1,2,3,4,5});    // Error even if operands are interchanged
        System.out.println(new int[] {1,2,3,4,5});
        System.out.println(new int[] {} + "a");
        System.out.println("a" + new ArrayList<>());
        System.out.println(new ArrayList<>() + "b");
        System.out.println("a" + new int[] {1,2,3,4,5});
        System.out.println((char)('a' + 5));
//        System.out.println(new ArrayList<>() + new int[] {}); // Error even if operands are interchanged
        System.out.println(new int[] {} + "" + new ArrayList<>());  // At least one is of type String among first 2 operands.
//        System.out.println(new Integer(56) + new ArrayList<>());  // Among first 2, nothing is String or primitive data type
        System.out.println(new Integer(56) + "" + new ArrayList<>());

        /*
        String has many methods for its objects
         */
        String name = "Sharan Jaiswal";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase()); // new object is creatd with all things in lower case
        System.out.println(name);   // original object doesn't gets changed
        System.out.println(Arrays.toString(name.split(" ")));   // split needs a regex and returns a String[] array


        // Replacing all whitespaces
        String white = "sljdbdvc j qfjv vx aj ljda ald   cl la  kac c a   k lda lma lm lc  ";
        System.out.println(white.replaceAll("\\s", ""));
    }
}
