package kk.oops.interfaces.nestedinterface;

public class A {
    public static interface NestedInterface {   // Inner interfaces are always static
        boolean isOdd(int num);
    }
    int a=56;
}

class B implements A.NestedInterface {
    @Override
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}

class Main {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.isOdd(5));

        A aObj = new A();
    }
}