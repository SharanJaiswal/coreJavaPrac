package kk.oops;

import java.lang.ref.WeakReference;

public class AGC {
    public static void main(String[] args) {
        SomeObj obj;
        for (int i = 0; i < 1000000; i++) {
            obj = new SomeObj();    // This is called Strong reference. In certain periodic time, AGC will only free the memory from heap iff this created object is not being referenced by any reference variable.
        }
        System.gc();


        System.out.println("Checking weak reference");
        WeakReference<SomeObj> weakRefObj = new WeakReference<>(new SomeObj());
        System.out.println(weakRefObj.get());   // Here it gives the toString value of SomeObj class obj, because AGC has not been hit yet luckily between creation of this obj and execution of this line
        System.gc();
        try{
            Thread.sleep(10000);
        } catch (Exception e) {}
        System.out.println(weakRefObj.get());   // gives null as AGC is hit already, and it swiped off the memory allocated in heap to the WeakReference object. It can be used for in-application caching.
    }
}

class SomeObj {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Object is getting Destroyed.");
    }

    @Override
    public String toString() {
//        return super.toString();
        return "Object od class SomeObj is present.";
    }
}
