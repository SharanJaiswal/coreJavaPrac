package kk.strings;

public class CompareStrings {

    public static void main(String[] args) {
        String st1 = "Scaler";
        String st3 = "Topics";
        String st4 = "ScalerTopics";
        String st5 = st1 + st3;
        System.out.println("Comparing st4 and st5: " + (st4.equals(st5)));
        System.out.println(st4 == st5);
        // equals internally calls toString values of the operands and compares the actual string value character by character to return the boolean value.
        // While '==' compares the memory location in case of objects, and values in case of primitives.
        String st6 = new String(st1 + st3);
        System.out.println(st4.equals(st6));
        System.out.println(st4 == st6);

        String st7 = new String("Scaler");
        System.out.println(st1.equals(st7));
        System.out.println(st1 == st7);

        String st8 = "Scaler";
        System.out.println(st1 == st8);
    }
}
