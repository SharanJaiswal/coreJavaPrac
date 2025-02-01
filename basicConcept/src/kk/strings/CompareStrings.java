package kk.strings;

public class CompareStrings {

    public static void main(String[] args) {
        String st1 = "Scaler";
        String st3 = "Topics";
        String st4 = "ScalerTopics";
        String st5 = st1 + st3;
        System.out.println("Comparing st4 and st5: " + (st4.equals(st5)));  // true
        System.out.println(st4 == st5); // false. String pool concept only works where natively we make new string with same existing value, i.e., with same literal.
        // equals internally calls toString values of the operands and compares the actual string value character by character to return the boolean value.
        // While '==' compares the memory location in case of objects, and values in case of primitives.
        String st6 = new String(st1 + st3);
        System.out.println(st4.equals(st6));    // true
        System.out.println(st4 == st6); // false

        String st7 = new String("Scaler");
        System.out.println(st1.equals(st7));    // true
        System.out.println(st1 == st7); // false

        String st8 = "Scaler";
        System.out.println(st1 == st8); // true because here literal values are same, hence st8 no longer made new string but pointed to the literal of st1.

        System.out.println(st1.compareTo(st7)); // 0 lexicographically comparison
        System.out.println(st1.compareToIgnoreCase(st7));   // 0

        String st9 = new String("Sharan");
        String st10 = "Sharan";
        System.out.println(st9.equals(st10));   // true
        System.out.println(st9 == st10);    // false because here we explicitly made st9 to point new memory location.
    }
}
