package kk.oops.interfaces.nestedinterface;

// Nested interface inside a class can be of any access modifier, because class can have members of any access type.
public class A {
    abstract public static interface NestedInterface {   // Inner interfaces are always static by default
        boolean isOdd(int num);
    }
    int a=56;

    void rand() {
        System.out.println("in rand method");
    }
}

class B implements A.NestedInterface {
    @Override
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    // Observe that error thrown when we tried to override "rand()"
    // because we are implementing nested interface, not extending the enclosing class.
//    @Override
//    void rand() {
//
//    }
}

class Main {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.isOdd(5));

        A aObj = new A();
        System.out.println(aObj.a);
        aObj.rand();
    }
}