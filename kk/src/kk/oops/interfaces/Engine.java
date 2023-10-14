package kk.oops.interfaces;

public interface Engine {
    static final int PRICE = 78000;

    // Even Media interface has start and stop method. So class that inherits both, its not specific from which start/stop is inherited
    public abstract void start();
    void stop();
    void acc();
}
