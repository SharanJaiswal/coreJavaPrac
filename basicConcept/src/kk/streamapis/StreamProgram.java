// https://www.baeldung.com/java-8-streams

/**
 * It is like a pipeline through which collection elements passes on which operation like filtering, sorting ext gets performed. Useful for bulk processing, parallel also.
 * It doesn't change the native collection.
 * Intermediate Operations: O/Ps streams, along with another operation done on it. Lazy in nature. i.e., invoked only when terminal operations are invoked.
 * eg- distinct, sorted([comparator],peek:doesn't do any processing as it takes a consumer, maybe used for sout,
 * Terminal: (optional) Triggers the processing of streams, and produces the output on which no more stream operation can be performed in the given stream.
 */
        package kk.streamapis;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamProgram {

    private static long counter;
    private static void wasCalled() { counter++; }


    public static void main(String[] args) {

        List<Integer> salaryList = new ArrayList<>();

        salaryList.add(3000);
        salaryList.add(4100);
        salaryList.add(9000);
        salaryList.add(1000);
        salaryList.add(3500);
        int count = 0;
        for (Integer salary : salaryList) {
            if (salary > 3000) {
                count++;
            }
        }
        long count1 = salaryList.stream().filter((Integer salary) -> salary > 3000).count();
        System.out.println(count + " " + count1);



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

//    Since Stream<T> is generic interface, therefore, specially, only 3 primitive types to elevate unnecessary auto-boxing of int, long and double interfaces are provided IntStream, LongStream, DoubleStream.
        IntStream intStream = IntStream.range(1, 3);    // end exclusive. For end inclusive: .rangeClosed(s,e);

//    We can instantiate a stream, and have an accessible reference to it, as long as only intermediate operations are called. Executing a terminal operation makes a stream inaccessible.
//    To demonstrate this, we will forget for a while that the best practice is to chain the sequence of operation. Besides its unnecessary verbosity, technically the following code is valid:
        Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));  // we have created stream using static method.
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

        // Stream can be of referenced data types, but not for primitives. But, there are certain primitive data type specific streams type: IntStream, DoubleStream, LongStream, using To{Int|Double|Long}Function
        int[] intarr = {2, 1, 4, 7};
        IntStream stream1 = Arrays.stream(intarr);
        int[] array1 = stream1.toArray();   // terminal operator to return an array.
        System.out.println(Arrays.toString(array1));
//        Integer[] specificObjTypeArr = Arrays.stream(intarr).toArray((int sizeOfObjectTypeArr) -> new Integer[sizeOfObjectTypeArr]);
        

        List<String> list1 = Arrays.asList("1", "2", "3", "4");
        IntStream integerStream = list1.stream().mapToInt((String num) -> Integer.parseInt(num));   // used ToIntFunction
        int[] array2 = integerStream.toArray();
        System.out.println(Arrays.toString(array2));

        // Intermediate operations are lazy, will be invoked only if it is necessary for the terminal operation execution.
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        // demo1:
        Stream<String> stringStream1 = list.stream().filter((String str) -> Integer.parseInt(str.substring(3, 4)) >= 2).peek((String str) -> System.out.println(str));  // NOT printing
        //demo2:
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


        // Sequence of Stream Operations:
        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numberStream = numbers.stream()
                .peek((Integer val) -> System.out.println("Initial Value: " + val))
                .filter((Integer val) -> val >= 3)
                .peek((Integer val) -> System.out.println("Filtered Value: " + val))
                .map((Integer val) -> val * -1)
                .peek((Integer val) -> System.out.println("Negated Value: " + val))
                .sorted()   // unless it gets all the eligible values, it doesn't gets executed.
                .peek((Integer val) -> System.out.println("Sorted Value: " + val));
        List<Integer> collected = numberStream.collect(Collectors.toList());
        numbers.stream().forEach((Integer val) -> System.out.println(val)); // Its like peek() but peek is intermediate operation while forEach is terminal operation, returns void.

        // Flat Map:
        List<List<String>> senetenceList = Arrays.asList(
          Arrays.asList("The ", "Quick ", "Brown "),
          Arrays.asList("Fox ", "Jumps ", "Over ", "A "),
          Arrays.asList("Lazy ", "Dog.")
        );
        Stream<String> stringStream = senetenceList.stream().flatMap((List<String> sentence) -> sentence.stream().map((String word) -> word.toLowerCase()));
        System.out.println(stringStream.collect(Collectors.toList()));

        // REDUCE: Terminal. Does reduction on the elements of the stream. Perform associative aggregation function. Accepts BinaryOperator.
        List<Integer> numnbers = Arrays.asList(2,1,4,7,10);
        Optional<Integer> reducedValue = numnbers.stream().reduce((Integer val1, Integer val2) -> val1+val2);   // we can put identity also as default|initial value as first param.
        System.out.println(reducedValue.get()); // 24

        int reducedParams = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (a, b) -> { System.out.println("combiner from sequential wasn't called"); return a + b; });
        System.out.println(reducedParams);  // 16
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> { System.out.println("aggregator combiner from parallel was called"); return a + b; });
        System.out.println(reducedParallel);    //36

        // First sorts the elements and then send the leftmost element
        Optional<Integer> minimumValueType1 = numnbers.stream().filter((Integer val) -> val>=3).min((Integer val1, Integer val2) -> val1-val2);
        System.out.println(minimumValueType1.get());    // 4
        Optional<Integer> minimumValueType2 = numnbers.stream().filter((Integer val) -> val>=3).min((Integer val1, Integer val2) -> val2-val1);
        System.out.println(minimumValueType2.get());    // 10
        // other  reduce operations are min, max, count, sum

        long cardinal = numnbers.stream().filter((Integer val) -> val>=3).count();
        System.out.println(cardinal);

        boolean has1 = numnbers.stream().anyMatch((Integer val) -> val>3);   // Terminal. Takes Predicate and returns a boolean.
        boolean has2 = numnbers.stream().allMatch((Integer val) -> val>3);
        boolean has3 = numnbers.stream().noneMatch((Integer val) -> val>3);
        System.out.println(""+has1+has2+has3);

        Optional<Integer> findFirstValue = numnbers.stream().filter((Integer val) -> val>=3).findFirst();
        Optional<Integer> findAnyValue = numnbers.stream().filter((Integer val) -> val>=3).findAny();
        System.out.println(findFirstValue.get() + " " + findAnyValue.get());


//        IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getPrice));
//        Map<Integer, List<Product>> collectorMapOfLists = productList.stream().collect(Collectors.groupingBy(Product::getPrice));
//        Map<Boolean, List<Product>> mapPartioned = productList.stream().collect(Collectors.partitioningBy(element -> element.getPrice() > 15));
//        Set<Product> unmodifiableSet = productList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }
}
