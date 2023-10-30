package kk.oops;

public class StaticBlock{
    static int a = 4;
    static int b;

    /*
    Since static variables are not object dependent, and in case where we want to initialize our static variables.
    This can be achieved via static block, which runs only exactly once when the class gets loaded for the very first time,
    i.e., when the first object gets created. Static block does not run after creation of first object.
     */

    static {
        System.out.println("I am in static block.");
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();   // On creating new object static block doesn't get executed. 'b' value is same.
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}
