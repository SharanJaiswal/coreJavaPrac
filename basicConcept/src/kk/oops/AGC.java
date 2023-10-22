package kk.oops;

public class AGC {
    public static void main(String[] args) {
        SomeObj obj;
        for (int i = 0; i < 1000000; i++) {
            obj = new SomeObj();
        }
    }
}

class SomeObj {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Object is getting Destroyed.");
    }
}
