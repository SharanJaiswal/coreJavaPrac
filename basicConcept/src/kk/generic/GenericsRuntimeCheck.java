package kk.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * type erasure in generics happens at compile time only, not at runtime when byte code is present, as byte code doesn't have any information regarding the generic.
 */
public class GenericsRuntimeCheck {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        addToNames(names, "Name 1");
        addToNames(names, "Name 2");
        System.out.println(names);  // [Name 1, Name 2]

        // Till compile time only, whatever has been provided under <> is checked, but once bytecode gets generated for runtime, the type assigned to the reference variable type in <>,
        // does not exist anymore. It's simply a reference variable of a given class type, ie, ArrayList<String> ls or ArrayList<Integer> li will be different till compile time only.
        // But in bytecode, they both will be simple ArrayList ls or ArrayList li.
        // After the introduction of generics in java, to make the code backward compatible, we can assign the generic type to non-generic type. But this comes with the cost.
        List names2 = names;    // RHS is list of generic type, while LHS is list of non-generic type. Here's where facade generates.

        incorrectAddToNames(names, 100);
        System.out.println(names);  // [Name 1, Name 2, 100] Here we can see that names is just a list of Strings but it has one element which is of type Integer.
        System.out.println(names.get(2) instanceof String); // false - We can also see that type conversion did not happen, ie, number is not stored as String
//        if(names.get(2) instanceof Integer) {
//            System.out.println(Boolean.TRUE);
//        } else {
//            System.out.println(Boolean.FALSE);
//        }

//        String name3 = names.get(2);  // This will give runtime error
        /**
         * The value inside <> is associated with the reference variable and not with the referenced object on RHS. So, when we assign names to names2, it just checked type compatibility.
         * Moreover, RHS's <> is not checked because it was not supposed to happen at compile time. Thus, only the fact is checked if RHS type (List) can be referenced with the LHS type.
         * On these facts, when we sent name to incorrectAddToNames method, it is assigned to parameter type List, where its body implementation is a part of runtime operation.
         * Moreover, when byte code is generated, since value of parameter received is no longer with <>, so to java at runtime, names is just a list which is now referenced by List
         * (method parameter); where it acts as a normal list. So, a normal list can add any type of element (any instance of Object), thus added Integer type into names list of String type.
         * But when names.get(2) gets assigned to name3 reference variable of String type, it gave error because names.get(2) gets called at runtime, and it is discovered at runtime that
         * names.get(2) is not of String type. Hence, it gave error. More specifically, ClassCastException.
         */



        // Replicating the above with Array data type
        String[] namesArray = new String[5];
        addToArray(namesArray, "Name1");
        incorrectAddToArray(namesArray, 10);
        String anotherName = namesArray[0];
        /**
         * The above situation gives runtime error but unlike giving it at place just above, it gives it in method incorrectAddToArray. It is because in that method, at runtime, java
         * knows that an array reference variable which is parameter, refers to an Array of String type. Thus, at runtime there is an awareness of type of array.
         * Hence, when we are assigning an integer value to an element of string array, it throws an error.
         *
         * We can visualize it as, in byte code, "Arraylist<DT>" will be converted as "Arraylist", bytecode will concern if its "Arraylist" type or not.
         * But in case of Array, "DT[]" will be subject of concern, ie, each element of DT[] will be of type DT which could only store/refer data/object of type DT or its subsequent children.
         */
    }

    private static void addToNames(List<String> names, String s) {
        names.add(s);
    }

    private static void incorrectAddToNames(List list, Integer i) {
        list.add(i);
    }

    private static void addToArray(String[] namesArray, String name1) {
        namesArray[0] = name1;
    }

    private static void incorrectAddToArray(Object[] namesArray, Integer i) {
        namesArray[0] = i;
    }
}
