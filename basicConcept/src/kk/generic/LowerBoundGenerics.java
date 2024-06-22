package kk.generic;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundGenerics {
    public static void main(String[] args) {
        // Until now, we have seen that it is impossible to add things, or to write things into the upper-bound generics type.
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        printNumbers(integers);  // 1 2

        List<Double> doubles = new ArrayList<>();
        doubles.add(3.0);
        doubles.add(4.0);
        printNumbers(doubles);      // 3.0 4.0

        addToList1(integers, 10);
        addToList1(doubles, 20);

        List<Number> numbers = new ArrayList<>();
        addToList2(numbers, 100);
    }

    private static void printNumbers(List<? extends Number> numbers) {
        numbers.forEach(System.out::println);
        Number number = numbers.get(0);
//        Integer number = numbers.get(0);  // we are doing wrong by assuming that numbers will have elements of some specific type of elements rather than of type Numbers.
    }

    private static void addToList1(List<? extends Number> numbers, Integer i) {
//        numbers.add(i); // This is giving error because in this method signature, attribute numbers is of type list which ensures that the elements of the list
        // can contain only elements of type Number or its derived types. It doesn't specifically tell that what could be the exact type of elements.
        // Hence, In case where the list of Integers is passed, then that Integer can be added to the list; but in case where a list of Double is passed, that list
        // will not add the integer to the list of Doubles. Hence, compiler will throw an error in general, because it's a compile time error. Therefore, java doesn't allow this possible situation to happen, and hence doesn't allow anything to write
        // to a list of some generics of child type, as siblings could conflict. Although, it can allow the write operation on the list of generic type of parents.
//         Also, the error will be same even if we change the param type of "i" to Number, because list "numbers" would still arise sibling type conflict. Eg, list passed of type Integer, and element passed is of type Float.
    }

     private static void addToList2(List<? super Number> numbers, Number i) {   // means anything of type Number of upstream super classes.
        numbers.add(i);
    }
    // The above works all cases where list is supposed to contain elements of type "Some_parent", and element added is of type "Some_parent" or its child classes. Hence, for each element reference variable of type "parent", can refer objects of type parent  or its derived classes.

    public void method1(List<? extends Number> list1, List<? extends Number> list2) {
        // In this, as we have used wildcards, we cannot be assured that both the parameters, i.e., List of same type. One could be of Integer, one could be of Double.
        // we can also use lower bounds with wildcards, i.e., we can use "super" keyword in place of "extends" as per our requirements.
    }

    public <T extends Number> void method2(List<T> list1, List<T> list2) {
        // In this, as we have used generics, we can be assured that both the parameters, i.e., List of same type.
        // We cannot use "super" keyword in place of "extends" keyword with generics. For that we need to go with wildcards.
    }
}
