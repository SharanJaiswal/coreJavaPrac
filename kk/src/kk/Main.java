package kk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        args passed to call the main method are stored in an String array,
        ie, the arguments will be casted as String irrespective of their data type by looks
         */
//        System.out.println(args[0] + " " + args[1]);

        Scanner input = new Scanner(System.in);
        System.out.println(input.nextInt());
        // INPUT: " The  quick brown fox jumps over the greedy dog   ..."
        /*
        next() works as if internally it first checks if the character to store is non-whitespace character or not.
        If it is non-whitespace character, then it starts to store the stream of characters.
        But when it does that, it does in same manner, ie, check if next character is non-whitespace char or not.
        Once it sees that next incoming char is whitespace char, then it stops reading. That unstored whitespace char
        then ready to be store by another input scanner. If next is also new next(), then it will not store char until
        non-whitespace char comes, and will store until non-whitespace char continues to occur. But if there is
        nextLine() method, this will store the whitespace character as well.
        Enter key is the end of the input,not stored anywhere.
         */
        System.out.println(input.next());
        System.out.println(input.next());
        System.out.println(input.next());
        System.out.println(input.nextLine());

        int a = 1_000_000_000;  // rendered as below var 'b', Cannot be scanner input in this form
        int b = 1000000000;
//        int c = 1,000,000,000;  // wrong as commas are not allowed

        /*
        For primitive data type everything on right is called literal, while things on left like the var_name,
        package name, class name, method name, interface name, etc.
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
//        byte y = e * r / t; // This gives error because byte expressions are evaluated as integer expressions.
                            // Result will be integer, looking to stored in byte. Do type casting to remove error.

        // Few basic progs
        System.out.println(Math.max(23, Math.max(45,78)));

        System.out.println(input.next().trim().charAt(0));  // charAt(idx) returns a char because String cant use var[idx]


        /* ========================= */
        /* ========================= */
        /* ========================= */
        /* ========================= */

        Main obj1 = new Main();
        System.out.println(obj1.getClass());    // obj.getClass() gives an object of type "Class". This object is stored in heap area
        System.out.println(obj1.getClass().getClass());
        System.out.println(obj1.getClass().getName());
    }
}
