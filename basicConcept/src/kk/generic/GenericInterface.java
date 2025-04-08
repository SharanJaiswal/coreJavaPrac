package kk.generic;

import java.util.function.*;

/**
 * Here we have defined one functional interface aka single abstract method(SAM) interface, which means it is an interface that contains only one abstract method. It can have multiple default and static methods.
 * e.g. Runnable, Comparable, ActionListener, Callable, etc.
 * Instantiate FIs by lambdas as a good practice.
 * @FunctionalInterface annotation is optional. But if it is there, then that interface cannot have more than one in count of abstract method in that interface.
 * all other type of methods, which does not need object specifically to call, in functional interface are allowed. Its just that total count of abstract method in functional interface cannot exceed 1.
 * Lambda expressions can be used to represent the instance of functional interface.
 */
public interface GenericInterface<T> {
    void display(T num);
}

@FunctionalInterface    // it is just an interface.It can be extended by other interfaces also, provided extending interface is functional, then it must shadow this abstract method.
interface AnotherGenericInterface {
    abstract public int calculate(int x);   // keywords "abstract" and "public" are redundant.

    default void nothing1() {}

    private void nothing2() {}

    static void nothing3() {}

    private static void nothing4() {}   // AVOID MAKING METHODS AS "PRIVATE STATIC" anywhere. THEY ARE INHERENTLY "FINAL". Better make separate utility class.

//    public abstract void nothing5() {}    // violates integrity of functional interface.

    // Below 2 would require an object to be called, hence breaking the integrity of an interface
//    void nothing5() {}
//    protected void nothing6() {}
}

//Functional interfaces can be extended by other functional interfaces if their abstract methods have the same signature.
@FunctionalInterface
interface ExtentedFI extends AnotherGenericInterface {
//    int calculate(int x); // although this works, but there is no point I can see because inherently it'll be extending it anyway.
//    One use case would be among all the extending FIs, we want to keep same abstract method, but we can change the private, static, private static, default.
}


//  https://www.geeksforgeeks.org/functional-interfaces-java/
/**
 * Runnable –> This interface only contains the run() method.
 * Comparable –> This interface only contains the compareTo() method.
 * ActionListener –> This interface only contains the actionPerformed() method. Used in AWT.
 * Callable –> This interface only contains the call() method.
 *
 * There are some already defined functional interface. Since these FI generally takes arguments of type of some class inside <>, hence there are some Int-Double etc. versions of them.
 * void {Consumer|DoubleConsumer|IntConsumer|LongConsumer}(obj); void BiConsumer(o1, o2);   boolean {Predicate|IntPredicate|DoublePredicate|LongPredicate}(o1); boolean BiPredicate(o1, o2);
 * {T|boolean|double|long|int} {Supplier<T>|BooleanSupplier|DoubleSupplier|LongSupplier|IntSupplier} ();
 * R Function<T,R>(o1)  ;  R BiFunction<T,U,R>(o1, o2)  ; T UnaryOperator<T>(o1)  ;   T BinaryOperator<T>(o1, o2)
 */

class FunctionalInterfaceTypesDemo {

    // Consumers have .andThen() method also for chaining
    Consumer<String> consumer = s -> {
        System.out.println( "Doesn't return anything." );
    };
    IntConsumer intConsumer = value -> System.out.println( "Doesn't return anything." );
    LongConsumer longConsumer = value -> System.out.println( "Doesn't return anything." );
    DoubleConsumer doubleConsumer = value -> System.out.println( "Doesn't return anything." );
    // BiConsumer takes generic type in no particular order. But order of input type will be same as of the order of generic type.
    BiConsumer<Integer, String> biConsumer = (integer, s) -> System.out.println( "Doesn't return anything." );
    // Extension of BiConsumer and DoubleConsumer|IntConsumer|LongConsumer where takes generic type as the type of object whose reference passed, and param order as (obj,int|double|long)
    ObjIntConsumer<String> objIntConsumer = (s, value) -> System.out.println( "Doesn't return anything." );
    ObjLongConsumer<String> objLongConsumer = (s, value) -> System.out.println( "Doesn't return anything." );
    ObjDoubleConsumer<String> objDoubleConsumer = (s, value) -> System.out.println( "Doesn't return anything." );

    // Suppliers don't take any input but returns always a boolean value.
    Supplier<String> supplier = () -> "String"; // () -> { return "String"; };
    BooleanSupplier booleanSupplier = () -> { return Boolean.TRUE; };   // true;    // Also, this return is showing of no use, but it is required if we are using {} in RHS of lambda where returning is necessary. It is expecting at least one statement before this return statement inside {}.
    IntSupplier intSupplier = () -> 36; // Although it is specifically made for primitive type "int", but we can send boxed value of int, of type Integer as "Integer.valueOf(36);
    LongSupplier longSupplier = () -> 36L;  // Long.valueOf(36[L]);
    DoubleSupplier doubleSupplier = () -> 36D;  // Double.valueOf(36[D]);

    // Predicate takes up values and returns a boolean value.
    Predicate<String> predicate = s -> false;
    BiPredicate<String, String> biPredicate = String::equalsIgnoreCase; // s.equalsIgnoreCase(s2)   // generic types can differ also.
    IntPredicate intPredicate = value -> value > 0;
    LongPredicate longPredicate = value -> value > 0L;
    DoublePredicate doublePredicate = value -> value > 0D;

    // Function takes Generic types where last type is return type and before that all are input argument types in the same order.
    Function<Integer, String> function = Object::toString;  // integer.toString() ====== We could have also written Integer::toString, but then it's ambiguous to select which version among toString() and toString(int)
    IntFunction<String> intFunction = value -> Integer.valueOf(value).toString();
    LongFunction<String> longFunction = value -> Long.valueOf(value).toString();
    DoubleFunction<String> doubleFunction = value -> Double.valueOf(value).toString();
    BiFunction<Double, String, Integer> biFunction = (aDouble, s) -> Integer.valueOf(s+aDouble.toString().substring(0, aDouble.toString().indexOf(".")));
    Function<String, String> identityFunction = Object::toString;  // returns what's given

    UnaryOperator<String> unaryOperator = s -> "String";    // take String and o/p String
    IntUnaryOperator intUnaryOperator = operand -> 0;   // int -> int
    LongUnaryOperator longUnaryOperator = operand -> 0L;
    DoubleUnaryOperator doubleUnaryOperator = operand -> 0D;
    BinaryOperator<String> binaryOperator = (s, s2) -> s+s2;    // (String, String) -> String   ----   Same as BiFunction<String, String, String>
    IntBinaryOperator intBinaryOperator = (left, right) -> right + (right - left) / 2;
    LongBinaryOperator longBinaryOperator = (left, right) -> right + (right - left) / 2;
    DoubleBinaryOperator doubleBinaryOperator = (left, right) -> right + (right - left) / 2;

    DoubleToIntFunction doubleToIntFunction = value -> (int) (value);   // Takes a "double" value and returns an "int" value. Also, possible all permutations of int|long|double.
    ToIntFunction<String> toIntFunction = value -> Integer.parseInt(value); // {Int|Long|Double} To{Int|Long|Double}Function<InputType>
    ToIntBiFunction<String, Boolean> toIntBiFunction = (s, aBoolean) -> 11; // {Int|Long|Double} To{Int|Long|Double}BiFunction<InputType>

    public static void main(String[] args) {
        FunctionalInterfaceTypesDemo functionalInterfaceTypesDemo = new FunctionalInterfaceTypesDemo();

        // We can join 2 predicate to make a new predicate:
        Predicate<String> negate = functionalInterfaceTypesDemo.predicate.and(functionalInterfaceTypesDemo.predicate).or(functionalInterfaceTypesDemo.predicate).negate();  // and or negate are the functionality provided by predicate.
        System.out.println(negate.test(""));

        // We have other methods inside Function interface other than apply()
        Function<String, String> integerVFunction = functionalInterfaceTypesDemo.identityFunction.andThen(functionalInterfaceTypesDemo.identityFunction);
        // first, function before "andThen" is executed with input; then its output will be put as input to function inside "andThen". Opposite behavior is seen when using .compose()
        System.out.println(integerVFunction.apply("5"));
    }
}
