package kk.oops.interfaces;

public interface Media {
    int  GLOBAL_VALUE = 42; // Interfaces can have global variables acts as a constants for the classes that will implement this interface. Those class can access these variables.
    // We can access these variables from classes implementing it as well as by using mere interface name reference.
    // We can read them only, not change their value as they act as constants. It is by default "public static final".


    // Even Engine interface has start and stop method. So class that inherits both, it's not specific from which start/stop is inherited
    void start();
    void stop();
}
