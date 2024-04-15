package multithreading;

// Not a good approach to implement multi-threading concept in java
// A Thread class itself is extending Runnable class. Hence, we can override the run method. Thread's start() method calls run() method. Hence, when we call start() using this class's instance, this run will execute.
public class MyThreadThread extends Thread {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("From Thread Extend ==> " + i);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
