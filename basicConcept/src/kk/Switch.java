package kk;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fruit = input.next();

//        switch (fruit) {
//            case "Mango" :
//                System.out.println("King of Fruits");
//                System.out.println("Favorite Fruit");
//                break;
//            case "Apple" :
//                System.out.println("A sweet red fruit");
//                break;
//            case "Orange" :
//                System.out.println("Round Fruit");
//                break;
//            case "Grapes" :
//                System.out.println("Small Fruit");
//                break;
//            default:
//                System.out.println("Enter valid Fruit");
//        }

        /*
        Enhanced Switch has break by default. Also, more than 1 statements needs to be boxed, for a given case.
        Nested switch can also be possible with both the style of switch
         */
        switch (fruit) {
            case "Mango", "kiwi" -> System.out.println("Favorite Fruits");
            default -> System.out.println("Enter valid Fruit");
            case "Apple", "Orange" -> { System.out.println("It might be Apple");
                                        System.out.println("It might be Orange"); }
            case "Grapes" -> System.out.println("Small Fruit");
        }
    }
}
/*
If there is a switch statement inside a method that expects something to be returned from each case, then there has to
be one more return statement outside the switch statement itself.
 */