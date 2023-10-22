/*
Generic is used extensively for TypeSafety
 */

package durg.learn;

import java.util.*;
public class Generics {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("TypeSafe");
        System.out.println(list);


        List anotherList = new ArrayList();
        anotherList.add("UnTypeSafe");
        System.out.println(anotherList);

        /*
        Both the lists are having much difference.
         */
    }
}

