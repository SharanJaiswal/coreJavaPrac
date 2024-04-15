package kk.generic;

/**
 * Here we have defined one functional interface aka single abstract method(SAM) interface, which means it is an interface the contains only one abstract method. It can have multiple default and static methods.
 * e.g. Runnable, Comparable, ActionListener, Callable, etc.
 * @FunctionalInterface annotation is optional. But if it is there, then that interface cannot have more than one in count of abstract method in that interface.
 */
public interface GenericInterface<T> {
    void display(T num);
}

@FunctionalInterface
interface AnotherGenericInterface {
    int calculate(int x);
}

//https://www.geeksforgeeks.org/functional-interfaces-java/
/**
 * There are some already defined functional interface. void {Consumer|DoubleConsumer|IntConsumer|LongConsumer}(obj); void BiConsumer(o1, o2);   boolean {Predicate|IntPredicate|DoublePredicate|LongPredicate}(o1); boolean BiPredicate(o1, o2);
 * {T|boolean|double|long|int} {Supplier<T>|BooleanSupplier|DoubleSupplier|LongSupplier|IntSupplier} ();
 * R Function<T,R>  ;  R BiFunction<T,U,R>  ; T UnaryOperator<T>  ;   T BinaryOperator<T,T>
 */