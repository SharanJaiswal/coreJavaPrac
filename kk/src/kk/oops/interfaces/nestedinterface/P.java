package kk.oops.interfaces.nestedinterface;

public interface P {
    public interface NestedInterface {
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