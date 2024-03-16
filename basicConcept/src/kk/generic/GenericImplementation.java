package kk.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericImplementation {
    public static void main(String[] args) {
        /**
         * Only if we provide the type of the generic parameter, then only that type is allowed.
         * Example, in gi1, arg1 can be of any type. But in gi2, arg1 must be of String type.
         */
        GenericInterface gi1 = (arg1) -> System.out.println(arg1);
        GenericInterface<String> gi2 = (agr1) -> System.out.println(agr1);


        /**
         * We cannot assign a specific type to its super type when it comes to generic, although generic is not in context then it's possible.
         * And thus, polymorphism and inheritance doesn't work with generics in the same way they work with classes otherwise.
         */
        List<String> names = new ArrayList<>();
        names.add("Name 1");
        names.add("Name 2");
//        printList1(names);   // Throws error, but to make it work, we can make parameter non-generic in method signature.
        printList2(names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
//        printList1(numbers); // Throws error, but to make it work, we can make parameter non-generic in method signature.
        printList2(numbers);


        // In similar way, it works with reference variable of generic type; can reference any object of specific generic type, in below 2 lines
        List<?> temp = names;
        temp = numbers;
        Object o = temp.get(0);
//        temp.add(56);   // throws error
    }

    private static void printList1(List<Object> itrList) {
        itrList.forEach(System.out::println);   // reading of elements
        itrList.add(3); // writing elements. This writing is the reason because of which assigning a child type generic to super type is restricted
        // It is because, in above example, if this restriction was not present, would added a number into a list of Strings
    }

    // ? actually means unknown type. So, as long as it is List of something, accept it.
    // Type checking will occur when we are attempting to call this method, not actually calling it on runtime.
    // All it can do is check at compile time
    private static void printList2(List<?> itrList) {   // Also, <? extends Numbers> to restrict to types that extends Numbers; Upper-Bound Wildcard
        itrList.forEach(System.out::println);   // reading operation is allowed with wildcard in generics
//        itrList.add("Foo"); // Writing operation is not allowed with wildcards in generics because writing could hamper the integrity of the type.
//        Eg, in case of list of numbers, String is passed.

        // Read operation is kind of behaving like list of Java Object
        Object o = itrList.get(0);
        // Number n = itrList.get(0);   // In case of Upperbound
    }
}

