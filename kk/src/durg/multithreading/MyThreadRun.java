package durg.multithreading;

public class MyThreadRun implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("From Runnable ==> " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Main Thread Starts...");
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        MyThreadRun thr = new MyThreadRun();
        Thread th1 = new Thread(thr);
        th1.start();

        MyThreadThread th2 = new MyThreadThread();
        th2.start();

        System.out.println("Main Thread Ends...");
    }
}