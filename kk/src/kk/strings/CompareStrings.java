package kk.strings;

public class CompareStrings {

    public static void main(String[] args) {
        String st1 = "Scaler";
        String st3 = "Topics";
        String st4 = "ScalerTopics";
        String st5 = st1 + st3;
        System.out.println("Comparing st4 and st5: " + (st4.equals(st5)));
        // equals internally calls ==, which compares the memory location in case of objects, and values in case of primitives.
    }
}
