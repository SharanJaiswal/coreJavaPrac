package kk.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericImplementation {
    public static void main(String[] args) {
        /**
         * Only if we provide the type of the generic parameter, then only that type is allowed.
         * Example, in gi1, arg1 can be of any type. But in gi2, arg1 must be of String type.
         */
        GenericInterface gi1 = (arg1) -> System.out.println(arg1);
        GenericInterface<String> gi2 = (agr1) -> System.out.println(agr1);
//        GenericInterface gi3 = (Integer arg1) -> System.out.println(arg1*arg1); // we can see that when we don't restrict the input type, the input is treated as of type Object.
        // Since in gi1 also we haven't defined the type of argument type, so lets see what happens when we pass integer to it
        gi1.display(23);    // This worked because sout first called the valueOf which returns the string value of 23 as "23" which eventually then print sit on the outstream. It is to note that sout is defined for all datatypes but not "*"

        AnotherGenericInterface fi1 = (x) -> x*x;   // Here we have provided the body to the SAM
        char e = 'e';
        System.out.println(fi1.calculate(e));

        /**
         * We cannot assign a specific type to its super type when it comes to generic; but when generic is not in context then it's possible.
         * And thus, polymorphism and inheritance doesn't work with generics in the same way they work with classes otherwise.
         */
        List<String> names = new ArrayList<>();
        names.add("Name 1");
        names.add("Name 2");
//        names.add(69);    // This will not work but adding a number to the list of Strings is possible from method printList1(), provided in its method signature we do not specify the list of some generic type.
//        names.add(Integer.valueOf("69"));
//        printList1(names);   // Throws error, but to make it work, we can make parameter non-generic in method signature.
        printList2(names);
        System.out.println(names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
//        printList1(numbers); // Throws error, but to make it work, we can make parameter non-generic in method signature.
        printList2(numbers);


        // In similar way, it works with reference variable of generic type; can reference any object of specific generic type but restricts write operation, in below 2 lines
        List<?> temp = names;
        temp = numbers;
        Object o = temp.get(0);
//        temp.add(56);   // throws error

        // Assigning non-generic type to generic type is also possible because of backward compatibility; also opposite way is also possible.
        List<String> lst1 = new ArrayList(); // While declaring, we also assign non-generic type to generic type.
        // But since LHS does the type check when we add element to this list in RHS reference variable, hence we can only add String type element.
//        lst.add(32);

//      Just above, the RHS doesn't have <> operator but LHS has, which means that only LHS does the type checking while adding the element to the RHS referenced variable.
//      But, there is no restriction or type-check happens on the type of element when element is added solely using the RHS. Here we are adding the elements from the list of Integers to the list of Strings and its working fine, as RHS doesn't have <>.
//      To make RHS restrictive of adding any type element but only type mentioned in the <> of LHS, we must also add <> operator on the RHS as well.
        List<Integer> tempLst = Arrays.asList(12,34,56);
        List<String> lst2 = new ArrayList(tempLst);
        System.out.println(lst2);
//        List<String> lst3 = new ArrayList<>(tempLst);   // Giving error as required element type is of String but provided are of Integers.
    }

//    private static void printList1(List itrList) {
        private static void printList1(List<Object> itrList) {
        itrList.forEach(System.out::println);   // reading of elements
        itrList.add(3); // writing elements. This writing is the reason because of which assigning a child type generic to super type is restricted
        // It is because, in above example, if this restriction was not present, would have added a number into a list of Strings
    }

    // ? actually means unknown type. So, as long as it is List of something, accept it.
    // Type checking will occur when we are attempting to call this method, not actually when calling it on runtime.
    // All it can do is check at compile time
    private static void printList2(List<?> itrList) {   // Also, <? extends Number> to restrict to types that extends Numbers; Upper-Bound Wildcard
        itrList.forEach(System.out::println);   // reading operation is allowed with wildcard in generics
//        itrList.add("Foo"); // Writing operation is not allowed with wildcards in generics because writing could hamper the integrity of the type.
//        Eg, in case of list of numbers, String is passed.

        // Read operation is kind of behaving like list of Java Object
        Object o = itrList.get(0);
        // Number n = itrList.get(0);   // In case of Upperbound
    }
}

