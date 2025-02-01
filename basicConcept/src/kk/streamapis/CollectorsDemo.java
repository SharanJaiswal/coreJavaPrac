package kk.streamapis;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsDemo {   // Collectors is a utility class, provides a set of methods to create a common collectors.
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Set<String> res = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toSet());

        // Collect to a specific collection
        ArrayDeque<String> collect = names.stream().collect((Collectors.toCollection(() -> new ArrayDeque<>())));   // toCollection() method takes Supplier which is just the data type object of the collection item

        // Joining String
        String concatenatedNames = names.stream().map((String::toUpperCase)).collect(Collectors.joining(", ")); // by default, the delimiter will be ""
        System.out.println(concatenatedNames);

        // Summarizing Data, i.e., generates statistical summary -- count, sum, min, max, average, max
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        // Calculating Averages::
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: " + average);

        // Counting elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        // Grouping Elements::
        List<String> words = Arrays.asList("hello", "world", "java", "stream", "collecting");
        Map<Integer, List<String>> grpByLen = words.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(grpByLen);
        Map<Integer, String> collectOperationOnGroup = words.stream().collect(Collectors.groupingBy((String::length), Collectors.joining(", ")));
        System.out.println(collectOperationOnGroup);
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));   // Count the count of elements in each group. Returns a Map
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));    // Gives any map implementation is we provide factory method of it. Could be LinkedHashMap also, or any map.
        System.out.println(treeMap);

        // Partitioning elements in 2 groups based on Predicate passed === key will be "true" and "false", while value for each key will be an array of elements
        System.out.println(words.stream().collect((Collectors.partitioningBy(x -> x.length() > 5))));

        // Mapping and Collecting ==== Applies a mapping function before collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));

//        Examples:::

//        1. Collecting names by length
        List<String> namesexample = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(namesexample.stream().collect(Collectors.groupingBy(x -> x.length())));
//        2. Counting words in a sentence
        String sentence = "hello world hello java world world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));
//        3. Partitioning even and odd numbers
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));
//        4. Summing up values in Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);
        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println(items.values().stream().collect(Collectors.summingInt(x -> x)));
//        5. Create a map from Stream elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length())));
//        6.
        List<String> words2 = Arrays.asList("Apple", "Banana", "apple", "orange", "banana", "apple");
        System.out.println(words2.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y)));
    }
}
