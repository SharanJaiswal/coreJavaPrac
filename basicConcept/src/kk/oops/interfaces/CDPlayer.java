package kk.oops.interfaces;

/*
This class is specifically for implementing only Media interface
 */
public class CDPlayer implements Media {
    int  GLOBAL_VALUE = 144;    // we can shadow them indeed as we are doing it here.
    int i = GLOBAL_VALUE;   // We can read those values but cannot change them, as they act as a constants.
    @Override
    public void start() {
        System.out.println("Music starts");
    }

    @Override
    public void stop() {
        System.out.println("Music Stops");
    }
}
