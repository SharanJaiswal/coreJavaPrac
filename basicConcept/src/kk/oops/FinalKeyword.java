package kk.oops;

public class FinalKeyword {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.NUM);
        System.out.println(a.BOBJ.state);
        System.out.println("After trying changing the final value");
//        a.NUM = 20; // cannot be possible as we are trying to change the value of reference variable which is final
        a.BOBJ.state = "New State.";
        System.out.println(a.NUM);
        System.out.println(a.BOBJ.state);

        // Seeing if singleton works or not by checking if the value of state is same on calling new obj of B from new Obj of A
        A newA = new A();
        System.out.println(newA.BOBJ.state);
        System.out.println(a.BOBJ == newA.BOBJ);    // confirmation that both the objects of A are holding/referencing same object of B
    }
}

class A {
    final int NUM = 10;
    final B BOBJ = B.getSingletonObjectOfB();
}

// Lazy Initialization: Since object is not preloaded in bootRun but created at runtime; Con: if 2 threads comes in parallel at start, both will get 1 different object each.
class B {
    String state = "Default State.";
    private static B singletonB;    // since its static, hence have null as default value if not instantiated

    private B () {};

    public static B getSingletonObjectOfB() {
        System.out.println(singletonB);
        if(singletonB == null) {
            singletonB = new B();
        }
        return singletonB;
    }
}

// Eager Initialization: (Eager:in advance) Because on application bootRun, all the static variables are preloaded.
class DBConnection1 {
    private static DBConnection1 connObject = new DBConnection1();
    private DBConnection1() {
    }
    public static DBConnection1 getInstance() {
        return connObject;
    }
}

// Synchronized Method: Remedy of Lazy init.
// "synchronized" lock and unlock the method for each thread. Con: Locking and unlocking is good at the start where no 2 thread will get different object,
// but bad when once object gets created because subsequent threads will also lock and unlock it even when it is not required.
class DBConnection2 {
    private static DBConnection2 connObject;
    private DBConnection2() {
    }
    public static DBConnection2 getInstance() {
        if (null == connObject) {
            connObject = new DBConnection2();
        }
        return connObject;
    }
}

// Double check locking: To overcome synchronized method.