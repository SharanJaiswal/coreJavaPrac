package kk.stringBufferClass;

/*
StringBuffer class object has mutable sequence of characters. Efficient as compare to String in terms of memory and time. Thread-safe hence slower.
While String build is non-thread-safe. Appending characters will not create new object of it, unlike arrays.
 */
public class Main {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();  // Default capacity of characters is 16
        sb1.append("WeMakeDevs");
        String str = sb1.toString();
        System.out.println(str);

        // Constructor 2:
        StringBuffer sb2 = new StringBuffer(20);
        // Constructor 3: Initializing with the character sequence
        StringBuffer sb3 = new StringBuffer("Sharan Jaiswal");

        sb1.append("Is nice.");
        sb1.insert(2, sb3);
        System.out.println(sb1);
        sb3.append("d g g g g g g ");
        System.out.println(sb1);

        sb1.replace(2,9, "saint");
        sb1.delete(9,12);
        System.out.println(sb1);


    }
}
