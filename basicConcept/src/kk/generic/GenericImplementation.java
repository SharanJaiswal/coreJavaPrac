package kk.generic;

public class GenericImplementation {
    public static void main(String[] args) {
        GenericInterface gi1 = (arg1) -> System.out.println(arg1);
        GenericInterface<String> gi2 = (agr1) -> System.out.println(agr1);
    }
}

/**
 * Only if we provide the type of the generic parameter, then only that type is allowed.
 * Example, in gi1, arg1 can be of any type. But in gi2, arg1 must be of String type.
 */