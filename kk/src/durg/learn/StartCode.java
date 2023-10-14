package durg.learn;

import java.util.*;

public class StartCode {
    public static void main(String[] args) {

    /*
        creating collection:
        1) Type safe: same type of elements (objects) are added to collection. Mentioned in and with diamond operator. <>
        2) UnType Safe: different type of elements(Objects) can be added to collection
        3) add() method is of Collection interface, hence can be applicable in all collection class.
     */
        // 1) But can be type unsafe also
        ArrayList<String> names = new ArrayList<>();
        names.add("Sharan");
        names.add("Jaiswal");
        names.add("Sharan");
        System.out.println(names);
        System.out.println(names.get(0));   // shows that it is indexed

        // 2) But can be type safe also
        LinkedList list = new LinkedList();
        list.add("Sachin");
        list.add(101);
        list.add(6785.453);
        list.add(true);
        System.out.println(list);

        //remove - removes first occurrence, not all
        names.remove("Sharan");
        System.out.println(names);

        //size
        System.out.println(names.size());

        //check if specific element is present or not.
        // "contains() uses "equals()" method.
        // We can override it if we are using any custom object to check its prescence.
        System.out.println(names.contains("Sharan"));


        // traversing using iterable (for-each)
        for(String str : names) {
            System.out.print(str + "\t" + str.length() + "\t");
            StringBuffer br = new StringBuffer(str);
            System.out.println(br.reverse());
        }
        
        // traversing using iterator
        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        // traversing using listIterator()
        /*
        Care should be taken here because we need to first move the cursor beyond the last element of the collection,
        for it to move backward.
        Otherwise, by default cursor will be supposedly at -1.
         */
        ListIterator<String> stringListIterator = names.listIterator(names.size());
        // If we won't provide names.size() , then there will be nothing to iterate at the back
        while(stringListIterator.hasPrevious()) {
            String previous = stringListIterator.previous();
            System.out.println(previous);
        }


        // traversing using forEach() method
        /*
        we pass one consumer to forEach() method. So, what inside of () is Consumer.
        Consumer is a functional interface.
        We provide the body of the function using lambda
         */
        names.forEach(ele -> {
            System.out.println(ele);
        });


        // TreeSet
        TreeSet<String> set = new TreeSet<>();
        set.addAll(names);  // stores all the elements of tree with rules of TreeSet
        // The above can be also represented as TreeSet set = new TreeSet<>(names);
        set.forEach(ele -> {
            System.out.println(ele);
        });

        // To override the alphabetical sorting logic used in TreeSet with the help of Comparable and Comparator



        // HashMap
        HashMap<String, Integer> courses = new HashMap<>();
        courses.put("Core Java", 34567);
        courses.put("Basic", 7890);
        courses.put("Android", 12345);
        courses.put("Android", 567890);
        System.out.println(courses);

        // forEach here need BiConsumer class which is a functional Interface.
        // It takes lambda, which needs 2 arguments
        courses.forEach((k, v) -> {
            System.out.println(k + "\t" + v);
        });


    }
}
