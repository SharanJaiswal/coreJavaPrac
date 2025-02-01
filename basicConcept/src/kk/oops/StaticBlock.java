package kk.oops;

import java.util.concurrent.TimeUnit;

public class StaticBlock{
    static int a = 4;
    static int b;

    /*
    Since static variables are not object dependent, and in case where we want to initialize our static variables.
    This can be achieved via static block, which runs only exactly once when the class gets loaded for the very first time,
    and has nothing to do with the timeline of creation of first object.
     */

    static {
        System.out.println("I am in static block.");
        b = a * 5;
    }

    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        // Before first object creation
        System.out.println("Before first object creation : " + StaticBlock.a + " " + StaticBlock.b);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        // After first object creation
        StaticBlock obj1 = new StaticBlock();
        System.out.println("After first object creation : " + StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();   // On creating new object static block doesn't get executed. 'b' value is same.
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}
