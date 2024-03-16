package kk.generic;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundGenerics {
    public static void main(String[] args) {
        // Until now, we have seen that it is impossible to add things, or to write things into the upper-bound generics type.
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        printNumbers(integers);

        List<Double> doubles = new ArrayList<>();
        doubles.add(3.0);
        doubles.add(4.0);
        printNumbers(doubles);

        addToList1(integers, 10);
        addToList1(doubles, 20);

        List<Number> numbers = new ArrayList<>();
        addToList2(numbers, 100);
    }

    private static void printNumbers(List<? extends Number> numbers) {
        numbers.forEach(System.out::println);
        Number number = numbers.get(0);
    }

    private static void addToList1(List<? extends Number> numbers, Integer i) {
//        numbers.add(i); // This is giving error because in this method signature, attribute numbers is of type list which ensures that the elements of the list
        // can contain only elements of type Number or its derived types. It doesn't specifically tell that what could be the exact type of elements.
        // Hence, In case where the list of Integers is passed, and Integer can be added to the list, but in case where a list of Double is passed, that list 
        // will not add the integer to the list of Doubles. Hence, compiler will throw an error in general, because it 's a runtime error.
    }

     private static void addToList2(List<? super Number> numbers, Number i) {   // means anything of type Number of upstream super classes.
        numbers.add(i);
    }
}
