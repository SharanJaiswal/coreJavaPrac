package durg.multithreading;

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
