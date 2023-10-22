package kk.functions;

import java.util.Scanner;

public class MethodShadowing {
    static int x = 90;  // For shadowing
    public static void main(String[] args) {
        String outer = "Sharan";
        {
            String inner = "Jaiswal";
            outer = inner;
            // both same as writing outer=inner;

            System.out.println(outer);
        }
        System.out.println(outer);

        // For shadowing continued...
        int x;
        x = 80; // scope will begin when value is initialized
        System.out.println(x);

        // For shadowing also
        sum();  // Although call is in scope where shadowing var is initialized, but the actual method is out of scope.
                // The scope of the called method is out of the shadowing scope, hence will access the shadowed var val.
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
