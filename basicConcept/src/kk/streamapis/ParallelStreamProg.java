package kk.streamapis;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
    }
}
