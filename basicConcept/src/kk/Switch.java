package kk;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fruit = input.next();

//        If there is a switch statement inside a method that expects something to be returned from each case including default, then there has to be at least one provision for return a value, for any of the possible scenario.
        System.out.println(returnTypeAnalysisInOldSwitch(fruit));
        System.out.println(returnTypeAnalysisInNewSwitch(fruit));
    }

    private static int returnTypeAnalysisInOldSwitch (String fruit) {
        switch (fruit) {    // Only allowed type inside switch conditional parenthesis -> byte,short,char,int, String, Enum
            case "Mango" :
                System.out.println("King of Fruits");
                System.out.println("Favorite Fruit");
                int i = 10; // We can define variables inside switch cases.
//                break;
                return 30;
            case "Apple" :  // fall-through pattern
            case "Lassan" :
                System.out.println("A sweet red fruit");
//                int i = 10;
// We CANNOT declare same name reference variables inside switch cases, if that variable name has already been defined in any previous case, happens only in old switch style.
//                break;
                return 40;
            case "Orange" :
                System.out.println("Round Fruit");
//                break;
                return 50;
//      default can be anywhere but should be accompanied by break statement if it is not at the last.
            default:
                System.out.println("Enter valid Fruit");
//                break;    // Always add break statement with every case and default because here if default hits, then it'll also go with cases below it, in break absence.
//                return 60;    // Siince this case doesn't have break or return statement, hence control will flow to next available case even if this case satisfies. Therefore, return statement requirement id fulfilled by next available case.
            case "Grapes" :
                System.out.println("Small Fruit");
//                break;
//                return 70;    // Only if any of the case misses return value, then, it looks for next available return statement. The next available return statement here is out of switch block.
        }
        return 1001;    // This will be not required if "Grapes" case included return statement, because every possible case then would be having return statement from this method.
    }

    private static int returnTypeAnalysisInNewSwitch (String fruit) {
         /*
        Enhanced Switch has break by default. Also, more than 1 statements needs to be boxed, for a given case.
        Nested switch can also be possible with both the style of switch
         */
        switch (fruit) {
            case "Mango", "kiwi" -> { System.out.println("Favorite Fruits"); int i = 10; return i; }
            default -> System.out.println("Enter valid Fruit");
            case "Apple", "Orange" -> { System.out.println("It might be Apple");
                System.out.println("It might be Orange");
                int i = 20; // In new switch style, variable scope is within the case only, NOT in the whole switch statement.
            return i; }
            case "Grapes" -> System.out.println("Small Fruit");
        }
        return 2001;
    }
}
