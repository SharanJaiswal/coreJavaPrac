package kk.oops.interfaces.nestedinterface;

// Nested interface inside interface must be public, as something(except private and static method) which don't have body in interface must be public.
public interface P {
    abstract public static interface NestedInterface {   // Inner interfaces are always static
        boolean isOdd(int num);
    }

    void rand();
}

class Q implements P.NestedInterface {
    @Override
    public boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    // Observe that we didn't have to override "rand()" because we are implementing nested interface, not the enclosing interface.
}

class Driver {
    public static void main(String[] args) {
        Q obj = new Q();
        System.out.println(obj.isOdd(5));
    }
}