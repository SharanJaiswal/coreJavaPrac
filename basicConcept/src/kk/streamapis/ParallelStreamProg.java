package kk.streamapis;

import java.math.BigInteger;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Concurrent streams in multi-core CPU. Uses "spliterator" function to split data into multiple chunks; & for task submission and parallel processing uses Fork-Join pool technique.
 */
public class ParallelStreamProg {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11,22,33,44,55,66,77,88,99,110);
        long startTime = System.currentTimeMillis();
        numbers.stream().map((Integer val) -> val * val).forEach((Integer val) -> System.out.println(val));
        System.out.println("Concurrent Time: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        numbers.parallelStream().map((Integer val) -> val * val).forEach((Integer val) -> System.out.println(val));
        System.out.println("Parallel Time: " + (System.currentTimeMillis() - startTime));


//        If the source of a stream is something other than a Collection or an array, the parallel() method should be used:
        IntStream intStreamParallel = IntStream.range(1, 150).parallel();
        System.out.println(intStreamParallel.isParallel());
//        The stream in parallel mode can be converted back to the sequential mode by using the sequential() method:
        IntStream intStreamSequential = intStreamParallel.sequential();
        System.out.println(intStreamSequential.isParallel());


        List<Integer> list2 = Stream.iterate(1, x -> x + 1).limit(2000).toList();   // If we want to get this output in form of array, we can use .toArray() in place of .toList()
        startTime = System.currentTimeMillis();
        List<BigInteger> list3 = list2.stream().map(ParallelStreamProg::factorial).sequential().toList();    // to make stream elements available in sequence, which in this case, already is.
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime)/100 + " seconds in non-parallel stream processing");

        startTime = System.currentTimeMillis();
        list3 = list2.parallelStream().map(ParallelStreamProg::factorial).sequential().toList();  // We used sequential here because we wanted to elements in the list to be in sequence, after they have been previously in parallel stream.
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime)/100 + " seconds in parallel stream processing");

        // Below we noticed that .sequential() will actually returns the stream where elements are in sequence as if they were processed sequentially. This we do, to make sequential available for further sequential processing
        System.out.println((list2.parallelStream().map(ParallelStreamProg::factorial).sequential().limit(200).toList())
                .equals
                        (list2.parallelStream().map(ParallelStreamProg::factorial).limit(200).toList()));


        // Cumulative sum [1, 2, 3, 4, 5] -> [1, 3, 6, 10, 15] :: where we see why parallel stream works flawlessly for only those scenarios where we don't have stateful requirements.
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
//        int sum = 0;    // since in lambda expressions, local variables used be used must be final or effectively final
        AtomicInteger sum = new AtomicInteger(0);
//        List<Integer> csParallel = numbers2.parallelStream().map(x -> {
//            int i = x + sum;
//            sum = i;
//            return i;
//        }).toList();
        List<Integer> cumulativeSum = numbers2.stream().map(sum::addAndGet).toList();
        System.out.println("Expected CS :: [1, 3, 6, 10, 15]");
        System.out.println("Actual in parallel stream ::" + cumulativeSum);
    }

    static BigInteger factorial(int num) {
        int i = 1;
        BigInteger ans = BigInteger.ONE;
        while (num != i) {
            ans = ans.multiply(BigInteger.valueOf(num));
            num--;
        }
        return ans;
    }
}
