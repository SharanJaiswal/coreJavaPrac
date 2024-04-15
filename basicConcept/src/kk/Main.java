package kk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        args passed to call the main method are stored in a String array, i.e., the arguments will be cast as String irrespective of their data type by looks
         */
//        System.out.println(args[0] + " " + args[1]);

        Scanner input = new Scanner(System.in);
        System.out.println(input.nextInt());
        // INPUT: " The  quick brown fox jumps over the greedy dog   ..."
        /*
        next() works as if internally it first checks if the character to store is non-whitespace character or not.
        If it is non-whitespace character, then it starts to store the stream of characters.
        But when it does that, it does in same manner, ie, check if next character is non-whitespace char or not.
        Once it sees that next incoming char is whitespace char, then it stops reading. That unsorted whitespace char
        then ready to be store by another input scanner. If next input stream reader is also new next(), then it will not store char until
        non-whitespace char comes, and will store until non-whitespace char continues to occur. But if there is
        nextLine() method, this will store the whitespace character as well.
        Enter key is the end of the input,not stored anywhere.
         */
        System.out.println(input.next());
        System.out.println(input.next());
        System.out.println(input.next());
        System.out.println(input.nextLine());

        // Java is strongly typed. Static typing. int type of variable can only contain int value, decided and checked at compile time. (Dynamic type is observed in python, where a=10, but can be a="Sharan".)
        // Before throwing an error when type doesn't match with the value, it checks and tries to do type conversion, internally or via casting. But casting happens at runtime.
        int a = 1_0_0_0_00_0_000;  // rendered as below var 'b', Cannot be scanner input in this form. We can place underscore anywhere in the number, even with floating-points also.
        int b = 1000000000;
//        int c = 1,000,000,000;  // wrong as commas are not allowed
        float flt = 23_456.75_01F;
        double dbl = 23_456.75_01;
        double val = 5.012E-15;
        double int_double = 25D;    // Specifying D is useful in cases when instead of double, we would have declared type as "var".
        long lng = 45378L;
        short shrt = 34;

        // lossy type casting
        b = (int) flt;
        System.out.println(b);  // no rounding off takes place

        int res1 = 3/2;
        double res2 = 3/2;  // NOT 1.5 because 3 and 2 are integers. int/int gives [precision lost] int result. that int result is then type converted to double.
        System.out.println(res1 + " = = = = " + res2);

        /**
         * For primitive data type everything on right is called literal, while things on left like the var_name,
         * package name, class name, method name, interface name, etc.
         * Literals: A way to specify values inline, for each of the primitive type.
         * int age = 25; int count = 0b101010;  // int literals
         *
         */


        float f1 = input.nextFloat();   // 10 : int to float as 10.0
        float f2 = input.nextFloat();   // 564.4567890 to rounded off
        float f3 = input.nextFloat();   // 999999999.4567896789
        System.out.println(f1 + "---" + f2 + "---" + f3);

        // never put big bytes into small bytes. If required, there will be byte loss and casting will be required
        int q = 257;
//        byte w = (byte)(a); // 257 % 256 = 1
//        System.out.println(w);

        byte e = 40; byte r = 50; byte t = 100;
        int d = e * r / t;  // Since LHS is bigger byte than RHS operands, then all RHS operands will be treated as int
        System.out.println(d);
        byte y =(byte) (e * r / t); //
        // If we would removed type casting (byte), then this would have given error because byte expressions are evaluated as integer expressions,ie., e r t will be promoted to int.
// Hence, result will be integer, looking to stored in byte. Do type casting to remove error.

        // Type Promotion : In any operation on RHS, first, among 2 operand, lower byte-sized OPERAND VALUE gets converted to higher byte sized OPERAND VALUE.
//        `````````(byte,short,char,int)````````` < (long) < (float) < (double)
        // Follows operator precedence order as well while selecting 2 operand at a time for performing operation.
        int num1 = 2;
        double num2 = 10;
        double res3 = num1 * num2;  // first VALUE OF num1 type will be promoted to double, then double num1 will be multiplied to double num2.
        System.out.println(res3);

        // Few basic progs
        System.out.println(Math.max(23, Math.max(45,78)));

        System.out.println(input.next().trim().charAt(0));  // charAt(idx) returns a char because String cant use var[idx]


        /* ========================= */
        /* ========================= */
        /* ========================= */
        /* ========================= */

        Main obj1 = new Main();
        System.out.println(obj1.getClass());    // obj.getClass() gives an object of type "Class" which has value "class package.s.UserClass". This object is stored in heap area.
        System.out.println(obj1.getClass().getClass()); // value to be printed is "class java.lang.Class"
        System.out.println(obj1.getClass().getClass().getClass()); // value to be printed is "class java.lang.Class" because .getClass() gives object of type Class.
        System.out.println(obj1.getClass().getName());  // package.s.ContextClass

        /**
         * Precedence order:
         * postfix > unary {++a, --a, +a, -a, ~a, !a} > multiplicative {* / %} > additive {+ -} > shift {<< >> >>>} > relational { < > <= >= instanceof} > equality {== !=} >
         *     & > ^ > | > && > || > ?: > assignment {= += -+ *= /= %= &= ^= |= <<= >>= >>>=}
         */
    }
}
