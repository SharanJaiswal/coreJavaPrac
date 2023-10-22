package kk.oops.interfaces;

/*
This class is specifically for implementing only Media interface
 */
public class CDPlayer implements Media {
    @Override
    public void start() {
        System.out.println("Music starts");
    }

    @Override
    public void stop() {
        System.out.println("Music Starts");
    }
}
