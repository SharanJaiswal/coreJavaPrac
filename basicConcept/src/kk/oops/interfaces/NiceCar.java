package kk.oops.interfaces;

public class NiceCar {  // we cannot extend both CD player and power engine class, just to check what happens when both classes have 2 methods with same signature.
                        // Also extending more than 2 classes are not allowed, but extending more than 2 interfaces is allowed.
    public Engine engine;
    public Media player = new CDPlayer();
    public NiceCar() {
        this.engine = new PowerEngine(); // default engine type in NiceCar
    }

    public NiceCar(Engine engine) {
        this.engine = engine;
    }
// Start/Stop method of engine behave according to which type of engine is in the Nice car; is it PowerEngine, or ElectricEngine
    public void startMyCar() {
        engine.start();
    }

    public void stopMyCar() {
        engine.stop();
    }

    public void startMusic() {
        player.start();
    }

    public void stopMusic() {
        player.stop();
    }

    // By this below method, which functionality of start/stop of engine should be executed, is decided
    public void upgradeEngine(Engine engine) {
        this.engine = engine;
    }
    public void upgradeEngine() {
        this.engine = new ElectricEngine();
    }

    // methods can also be provided to set back default engine type
}
