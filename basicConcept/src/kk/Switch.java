package kk;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fruit = input.next();

        switch (fruit) {    // Only allowed type inside switch conditional parenthesis -> byte,short,char,int, String, Enum
            case "Mango" :
                System.out.println("King of Fruits");
                System.out.println("Favorite Fruit");
                int i = 10; // We can define variables inside switch cases.
                break;
            case "Apple" :  // fall-through pattern
            case "Lassan" :
                System.out.println("A sweet red fruit");
//                int i = 10;
// We CANNOT declare same name reference variables inside switch cases, if that variable name has already been defined in any previous case, happens only in old switch style.
                break;
            case "Orange" :
                System.out.println("Round Fruit");
                break;
//      default can be anywhere but should be accompanied by break statement
            default:
                System.out.println("Enter valid Fruit");
//                break;    // Always add break statement with every case and default because here if default hits, then it'll also go with cases below it, in break absence.
            case "Grapes" :
                System.out.println("Small Fruit");
                break;
        }

        /*
        Enhanced Switch has break by default. Also, more than 1 statements needs to be boxed, for a given case.
        Nested switch can also be possible with both the style of switch
         */
        switch (fruit) {
            case "Mango", "kiwi" -> { System.out.println("Favorite Fruits"); int i = 10; }
            default -> System.out.println("Enter valid Fruit");
            case "Apple", "Orange" -> { System.out.println("It might be Apple");
                                        System.out.println("It might be Orange");
                                            int i = 10; }   // In new  switch style, variable scope is within the case only, NOT in the whole switch statement.
            case "Grapes" -> System.out.println("Small Fruit");
        }
    }
}
/*
If there is a switch statement inside a method that expects something to be returned from each case including default,
then there has to be one more return statement outside the switch statement itself.
 */