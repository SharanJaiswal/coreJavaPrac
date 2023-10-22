package kk.oops.interfaces;

public interface Media {
    // Even Engine interface has start and stop method. So class that inherits both, its not specific from which start/stop is inherited
    void start();
    void stop();
}
