package kk.oops.interfaces;

public class Car implements Engine, Break, Media {

    int a = 40;
    @Override
    public void applybreak() {
        System.out.println("I apply break like a normal car.");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car.");
    }

    // Below 2 overridden methods are in both interface, Engine and Media. Hence, it's difficult to decide, which version is bind
    // Also, those interface methods don't have body to distinguish. Their body is defined in class implementing them.
    // To overcome the below resolution, it's better to implement Engine and Media separately and two different class,
    // provide them their own body, and use their object to call them respectively.
    @Override
    public void start() {
        System.out.println("I start engine like a normal car.");
    }

    @Override
    public void stop() {
        System.out.println("I stop engine like a normal car.");
    }

}
