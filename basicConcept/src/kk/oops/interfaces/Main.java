package kk.oops.interfaces;

// Interface helps 2 system to interact with each other w/o knowing the details of other; to achieve full abstraction. System calls exposed fly operation.
// only public and default are allowed as outermost interface access modifier.
// Interfaces are "abstract" by default.

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.applybreak();
        car.acc();
        car.start();
        car.stop();
        car.defMet();
//        Engine.defMet();  // Default methods of an interfaces can be called via only object references of classes or its child implementing that interface.

        Engine car2 = new Car();
//        car2.a;   // Gives error because Engine type reference variable cannot find variable named "a" to refer, although Car having its version of "a".

        Media carMedia = new Car(); // We wanted to start media, but it's starting the car.

        NiceCar car3 = new NiceCar();
        car3.startMyCar();
        car3.stopMyCar();
        car3.startMusic();
        car3.stopMusic();

        car3.upgradeEngine(new ElectricEngine());
        car3.startMyCar();  // Now when car starts, electric engine will gets start
        car3.stopMyCar();
        car3.startMusic();
        car3.stopMusic();
    }
}
