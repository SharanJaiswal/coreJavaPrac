package kk;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fruit = input.next();

//        If there is a switch statement inside a method that expects something to be returned from each case including default, then there has to be at least one provision for returning a value, from all the possible scenario. Also, the implementation of that method should return a value from all the possible paths.
        System.out.println(returnTypeAnalysisInOldSwitch(fruit));
        System.out.println(returnTypeAnalysisInNewSwitch(fruit));

        // Whenever we are using block in an expression, and we wanted to return a value, we must use "yield". New version of java allows return statement in expression block. Previous versions don't.
        int val = 1;
        String outVal = switch (val) {
            case 1 -> {
                System.out.println("-");
                yield "One";
            }
            case 2 -> {
                System.out.println("--");
                yield "Two";
            }
            default ->  "rest";
        };
    }

    private static int returnTypeAnalysisInOldSwitch (String fruit) {
        switch (fruit) {    // Only allowed type inside switch conditional parenthesis -> byte,short,char,int, String, Enum, Integer, SHort, Byte, Char
            // Make sure all the possible cases are handled, hence for those unknown cases we use default case.
            case "Mango" :
                System.out.println("King of Fruits");
                System.out.println("Favorite Fruit");
                int i = 10; // We can define variables inside switch cases.
//                break;
                
//                return 30;
            case "Apple" :  // fall-through pattern
            case "Lassan" :
                System.out.println("A sweet red fruit");
//                int i = 10;
// We CANNOT "declare" same name reference variables inside switch cases, if that variable name has already been "declared" in any previous case.
// This expansion of accessibility of declared variable happens only in old switch style. In new style, we need to both declare and define variable with same name.
//                break;
                i = 40; // declaration of variable in any case is scoped for whole switch statement, but its value needs to be initialized in every case block.
                return i;
            case "Orange" :
                System.out.println("Round Fruit");
//                break;
                return 50;
//      default can be anywhere but should be accompanied by break statement if it is not at the last.
            default:
                System.out.println("Enter valid Fruit");
//                break;    // Always add break statement with every case and default because here if default hits, then it'll also go with cases below it, in break absence.
//                return 60;    // Since this case doesn't have break or return statement, hence control will flow to next available case even if this case satisfies. Therefore, return statement requirement is fulfilled by next available case.
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
            default -> System.out.println("Enter valid Fruit"); // we cannot use 'i' with re-declaring it
            case "Apple", "Orange" -> { System.out.println("It might be Apple");
                System.out.println("It might be Orange");
                int i = 20; // In new switch style, variable scope is within the case only, NOT in the whole switch statement. We have to declare as well as define again the variable with same name.
            return i; }
            case "Grapes" -> System.out.println("Small Fruit");
        }
        return 2001;
    }
}
