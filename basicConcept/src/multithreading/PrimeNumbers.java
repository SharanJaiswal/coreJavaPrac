package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        Runnable statusReport = () -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    printThreads(threads);
                    // If in our run method, there is provision where InterruptedException is thrown (sleep, etc.), we need to check if thread of the run() is interrupted inside the run() executable code.
                    // Here, this while() loop is run()'s executable code. If, there had been no sleep(), then we would have thrown Interrupted exception or break out of this while loop, just to stop executable code execution.
//                    if (Thread.interrupted()) {
//                        break;
//                        Stop executing the run() task, either by break, or below exception throw. We must handle this thrown exception.
//                        throw new InterruptedException();
//                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Status report thread interrupted. Ending status updates.");
//                e.printStackTrace();
            }
        };

        Thread reporterThread = new Thread(statusReport);
        reporterThread.setDaemon(true);
        reporterThread.start();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nI can tell you Nth Prime Number. Enter N: ");
            int n = sc.nextInt();
            if (n == 0) {
                reporterThread.interrupt(); // Since Java 1.2, stop() is deprecated. Hence, we use interrupt() which clean up and shut down a particular thread. SOFT INTERRUPTS(in java, for threads) =/= HARDWARE INTERRUPTS (in OS, for process).
                try {
                    System.out.println("Waiting for all threads to finish...");
                    waitForThreads(threads);
                    System.out.println("Done with the application. " + threads.size() + " primes calculated.");
                } catch (InterruptedException e) {
                    System.out.println("\n Got interrupted when waiting for threads. Quitting...");
                }
                break;
            }
            Runnable r = new Runnable() {
                @Override
                public void run() {
//                    int number = PrimeNumbers.calculatePrime(n);
                    int number = 10;
                    System.out.println("\n Result:");
                    System.out.println("\n Value of " + n + "th prime: " + number);
                }
            };
            Thread t = new Thread(r);
            threads.add(t);
            t.start();
        }
    }

//    private static int calculatePrime(int n) {
//    }

    private static void waitForThreads (List<Thread> threads) throws InterruptedException {
        for (Thread thread :threads) {
//            if (!thread.getState().equals(Thread.State.TERMINATED)) { // redundant logically because if a thread is terminated, there is NO waiting for it to complete. Terminated thread doesn't make parent wait.
                thread.join();
//            }
        }
    }

    private static void printThreads (List<Thread> threads) {
        System.out.println("\n Threads status: ");
        threads.forEach(thread -> {
            System.out.println(thread.getState() + " ");
        });
        System.out.println("");
    }
}
