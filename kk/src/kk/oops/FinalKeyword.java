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
        System.out.println(a.BOBJ == newA.BOBJ);    // confirmation that both the objects of A are holding same object of B
    }
}

class A {
    final int NUM = 10;
    final B BOBJ = B.getSingletonObjectOfB();
}

class B {
    String state = "Default State.";
    private static B singletonB;

    private B () {};

    public static B getSingletonObjectOfB() {
        if(singletonB == null) {
            singletonB = new B();
        }
        return singletonB;
    }
}