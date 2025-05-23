package kk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {    // String... args
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

        // byte size of primitive data types (byte(1B)->short.   char(2B)->int.    short(2B)->int(4B)->long(8B)->float(4B)->double(8B),boolean) // Arrow indicates widening
        // Java is strongly|static typed. int type of variable can only contain int value, decided and checked at compile time. (Dynamic type is observed in python, where a=10, but can be a="Sharan".). Expression type is also checked for compatibility. This avoids runtime errors.
        // Before throwing an error when type doesn't match with the value, it checks and tries to do type conversion, internally or via casting. But casting happens at runtime.
        int a = 1_0_0_0_00_0_000;  // rendered as below var 'b', Cannot be scanner input in this form. We can place underscore anywhere in the number, even with floating-points also.
        // These dunders cannot be placed adjacent to point in floating literals, before F or D or L, at the beginning or end of a number,
        int b = 1000000000; // 4-bytes
//        int c = 1,000,000,000;  // wrong as commas are not allowed
        // All floating point literals are by default of type double. So, we cannot assign only numeric floating literals to reference type of "float" without f or F. Same goes for int (default) into bytes or long or short.
        float flt = 23_456.75_01F;  // can be upper case or lower case f or F.  4-bytes
//        float f3 = 2983.54; // Error because RHS is interpreted as double. Trying to fit in 8-bytes in 4-bytes
        double dbl = 23_456.75_01;
        double val = 5.012E-15;
        double int_double = 25D;    // Specifying D or d is useful in cases when instead of double, we would have declared type as "var".
        long lng = 45378L;  // both cases of l or L == 8-bytes
        long lng2 = 45378;  // Widening casting as RHS alone is of type int which is wide casted into long
//        int lng3 = 45378L;  // required int, provided long
        short shrt = 34;
        // long can be casted into the float, even though the casting is happening from 8B to 4B, is because float can represent the values in the scientific notation as well, if the range goes beyond 4B

        // lossy type casting, aka Narrowing
        b = (int) flt;  // happens at runtime
        System.out.println(b);  // no rounding off takes place 23456

        int res1 = 3/2; // 1, not because LHS is having reference variable of type 'int', but depends upon the type of operand. See below example.
        double res2 = 3/2;  // NOT 1.5 because 3 and 2 are integers. int/int gives [precision lost] int result. that int result is then type converted to double.
        System.out.println(res1 + " = = = = " + res2);  // 1 = = = = 1.0

        /**
         * Literal is an actual constant value which is stored in a variable. Reference variables for primitives can store actual value and can also point to another primitive reference variable.
         * Reference variable pointing to some object holds object reference as a literal. Exceptionally, Strings can have literals.
         * For primitive data type everything on right is called literal, while things on left like the var_name,
         * package name, class name, method name, interface name, etc.
         * Literals: A way to specify values inline, for each of the primitive type.
         * int age = 25; int count = 0xaF10(hexadecimal form-0x), int count = 0b0101(binary-0b|0B);  int count = 010 (octal-0x), // int literals
         * There are no byte or short literals.
         * char literals: char a = 'a'; char a = 97 : 0xFFCE : 07777: 65535 :  65536(error);    char literals can hold integer literals of any type, but allowed unicode range is [0-65535]
         * Every escape character is possible char literal. \n (new line), \t (hor tab), \r (carriage return), \b (backspace), \f (form feed), \' , \", \\
         */


        float f1 = input.nextFloat();   // 10 : int to float as 10.0
        float f2 = input.nextFloat();   // 564.4567890 to rounded off
        float f3 = input.nextFloat();   // 999999999.4567896789
        System.out.println(f1 + "---" + f2 + "---" + f3);   // 10.0---564.4568---1.0E9

        // never put big bytes into small bytes. If required, there will be byte loss and casting will be required
        int q = 257;
        byte w = (byte)(q); // byte:[-128 to 127],
        // So, X=257-127=130 => 130 % 256 = 130. Now, we considered only positives. Let's shift origin ,i.e., 0 as -128; therefore, 130 will be as 1
        // Or, simply, X % 256 = R[0,255](1 to 255, then 0, where 0 means its 256th number and 1 means 1st number).
        // Shift back origin where R=1 refers to -128 in byte. Therefore, answer in byte: R-129
        System.out.println(w);

        byte e = 40; byte r = 50; byte t = 100;
        int d = e * r / t;  // Since byte operation happens as int operation, also LHS is bigger byte than RHS operands, then all RHS operands will be treated as int
        System.out.println(d);
        byte y =(byte) (e * r / t);
        System.out.println(y);
        // If we would removed type casting (byte), then this would have given error because byte expressions are evaluated as integer expressions,i.e., e r t will be promoted to int.
// Hence, result will be integer, looking to stored in byte. Do type casting to remove error.

        // Type Promotion : In any operation on RHS, first, among 2 operand, lower byte-sized OPERAND VALUE gets converted to higher byte sized OPERAND VALUE.
//        `````````(byte->short,char->int,short->int) -> int->long->float->double
        // Follows operator precedence order as well while selecting 2 operand at a time for performing operation.
        int num1 = 2;
        double num2 = 10;
//        int res3 = num1 * num2;  // first VALUE OF num1 type will be promoted to double, then double num1 will be multiplied to double num2 giving double.
        double res3 = num1 * num2;
//        float res3 = num1 * num2; // this will also not work because default floating -value type will be double whose size > size of float. But, here we are trying to put double(RHS) to float(LHS). Hence, giving error.
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
        System.out.println(obj1.getClass().getSimpleName());  // ContextClass

        /**
         * Precedence order:
         * -> . () []    L-R
         * postfix > unary(R-L) {++a, --a, +a, -a, ~a(bit-w, 1's comp; =-(a+1)), !a} > multiplicative {* / %} > additive {+ -} > shift {<< >> >>>} > relational { < > <= >= instanceof} > equality {== !=} >
         *     & > ^ > | > && > || > ?:(R-L) > assignment(R-L) {= += -+ *= /= %= &= ^= |= <<= >>= >>>=}
         *     Comma
         */

        // Binary operators are only supported by whole numbers, i.e., byte, short, int, long, and their wrapper classes.
        int n1 = 5, n2 = 2;
        System.out.println(n1 + "===" + n2);
        System.out.println("5 in binary: " + Integer.toBinaryString(n1));
        System.out.println("Negated 5 in binary: " + Integer.toBinaryString(~n1));
        System.out.println("Signs are preserved in right shift, aka, signed right shift; while in unsigned MSB is always set as 0");
        System.out.println("5 on left shift by 2: " + Integer.toBinaryString(n1 << n2));
        System.out.println("-5 on left shift by 2: " + Integer.toBinaryString(-n1 << n2));
        System.out.println("5 on right shift by 2: " + Integer.toBinaryString(n1 >> n2));
        System.out.println("-5 on right shift by 2: " + Integer.toBinaryString(-n1 >> n2));
        System.out.println("5 on unsigned right shift by 2: " + Integer.toBinaryString(n1 >>> n2));
        System.out.println("-5 on unsigned right shift by 2: " + Integer.toBinaryString(-n1 >>> n2));
    }

    // member variable: when object is created, each object has own new copy of this member variable.
    int mem_var1;
    // Local variable: which is defined inside a method, a block; scoped within that only.
    // static var: objects refers to this variable, objects doesn't have its copy. Only 1 copy exists on class level.
    static int num1 = 32;
    // method variables: method arguments.
    // constructor variables: parameters of parameterized constructors.
    // "new" keyword allocates memory in heap.

//    Datatypes: 1) 8-Primitive dts;  [primitive<-unboxing- -autoboxing->wrapper ]  2) 4-Reference dts {Class, String, Interface, Array}

}
