// https://www.baeldung.com/java-8-streams

package kk.streamapis;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamProgram {

    private static long counter;
    private static void wasCalled() { counter++; }


    public static void main(String[] args) {

        // Stream instance can be created of different sources, changes into which doesn't change the source. Hence, from a given source, multiple independent streams can be created.

        // Creating empty stream, usually done to avoid returning null and return this empty stream reference.
        Stream<String> streamEmpty1 = Stream.empty();

        // Stream of any Collection type can be created
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        // Stream of an array:
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        // generate() accepts Supplier<T>. If .limit(N) is not mentioned, then generated stream will be of infinite size until memory overflow happens.
        Stream<String> streamGenerated1 = Stream.generate(() -> "element").limit(10);
//    Stream<String> streamGenerated2 = Stream.generate(() -> "element");   // DANGEROUS

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);  // First param is first element of stream, while Ith is i+2

//    Since Stream<T> is generic interface, therefore, specially, only 3 primitive types int, long and double interfaces are provided IntStream, LongStream, DoubleStream.
        IntStream intStream = IntStream.range(1, 3);    // end exclusive. For end inclusive: .rangeClosed(s,e);

//    We can instantiate a stream, and have an accessible reference to it, as long as only intermediate operations are called. Executing a terminal operation makes a stream inaccessible.
//    To demonstrate this, we will forget for a while that the best practice is to chain the sequence of operation. Besides its unnecessary verbosity, technically the following code is valid:
        Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement1 = stream.findAny();
//    However, an attempt to reuse the same reference after calling the terminal operation will trigger the IllegalStateException:
//    Optional<String> firstElement1 = stream.findFirst();
//    As the IllegalStateException is a RuntimeException, a compiler will not signalize about a problem. So it is very important to remember that Java 8 streams can’t be reused.
//    This kind of behavior is logical. We designed streams to apply a finite sequence of operations to the source of elements in a functional style, not to store elements.
//    So to make the previous code work properly, some changes should be made:
        List<String> elements = Stream.of("a", "b", "c").filter(element -> element.contains("b")).collect(Collectors.toList());
        Optional<String> anyElement2 = elements.stream().findAny();
        Optional<String> firstElement2 = elements.stream().findFirst();

        //  source, intermediate operation(s) and a terminal-operation(can only be one in number)
        Stream<String> twiceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1).map(element -> element.substring(0, 3));
        long size = Arrays.asList("abc1", "abc2", "abc3").stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();    // example of terminal operation



        // Intermediate operations are lazy, will be invoked only if it is necessary for the terminal operation execution.
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream2 = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });
//        counter is still zero, so the filter() method was not even called once. The reason why is missing of the terminal operation.
        System.out.println(counter);

        // Fix: here, filter() called twice and map() once because pipeline executes vertically
        Optional<String> stream3 = list.stream().filter(element -> {
            System.out.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();

//        Order of Execution in chaining in Stream affects costs of execution of code.
        long size1 = list.stream().map(element -> { wasCalled(); return element.substring(0, 3); }).skip(2).count();    // size1=1; increase counter by 3 (times map() is called, unnecessary 2 map() calls made.)
        long size2 = list.stream().skip(2).map(element -> { wasCalled(); return element.substring(0, 3); }).count();    // size2=1; avoided 2 unnecessary map() calls. map() only called once.
//        Intermediate operations which reduce the size of the stream should be placed before operations which are applying to each element.
//        So we need to keep methods such as skip(), filter(), and distinct() at the top of our stream pipeline.



        // REDUCE

    }
}
