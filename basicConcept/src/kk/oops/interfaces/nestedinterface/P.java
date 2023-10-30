package kk.oops.interfaces.nestedinterface;

public interface P {
    public static interface NestedInterface {   // Inner interfaces are always static
        boolean isOdd(int num);
    }
}

class Q implements P.NestedInterface {
    @Override
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}

class Driver {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.isOdd(5));
    }
}