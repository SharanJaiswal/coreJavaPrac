package multithreading;
// A Thread a single unit sequential flow of control. Multi-threading allows programs to split into simultaneously running task.
// Application,Program,App,Software,etc., when start to run, OS loads that programs to memory, allocates resources, executes. All theses together comes under running a process. When app closes, process ends.
// Allocated resources for a process is kept isolated from other process by OS. Every process inherently works in a sandbox environment. But, there are some shred resources between processes, like HDD.
// The only way one process can affect other process is by creating resource scarcity for other process to execute. Default execution mode of process is concurrent handled by OS
// Thread is a child of process. A process runs on a core by default sequentially. To leverage other cores, to run those sequential process parallel, we make threads. Threads under a process have shared objective.
// JVM process starts, memory allocation happens, multiple threads spawn including garbage collection, security, Application thread, etc. responsible for running main thread. Multiple thread spawn from App thread.
// We can make thread using "Thread" class. We can run block of statements in a thread by using "Runnable" interface, having "public void run()" method which runs our thread specific block of executable statements.
// Implement Functional Interface Runnable, put code in run(), create Runnable implementing class object, create a thread using that object, start that thread, JVM calls underlying OS threading APIs.
// A thread ends when it returns something, or when exception is thrown from that thread. A Thread class itself is extending Runnable class. While Java app ends when app thread and all child thread ends.

// 1 Use case: when loop is in main thread and each iteration takes time, then we'll move the time taking code to a new Runnable object, and create and start a new thread. In this way, in background, code which was
// taking time in each iteration, will now be run in separate thread but next iteration will be faster, without waiting for previous iteration/task to complete, to start serving new iteration.

// Until all the "user-threads" stops executing, java app doesn't stop, even though the Application thread executes completely. Now, to stop user child threads when parent main thread stops executing,
// make user thread(s) as Daemon thread. Life-cycle of Daemon thread depends on life-cycle of parent thread. Thread t1 = new Thread(rnblObj); t1.setDaemon(true); t1.start();

// Life-cycle of thread [enum Thread.State]: Thread.getState()
// "NEW":created -> {started} -> "RUNNABLE": {not-running} <=> [running] {{JVM creates and start the thread, where start() tells OS scheduler to take over. JVM doesn't tuns threads}}{{ In state to be picked by OS scheduler if processing core is available }}
//                                  ||      <-> "BLOCKED": e.g., lock(), etc. {{ Not in state to be picked by OS scheduler if processing core is available }}
//                                  ||      <-> "WAITING": {not blocked but waiting fo something to happen and might go into running state}; e.g., join(), etc. {{ Not in state to be picked by OS scheduler if processing core is available }}
//                                  ||      <-> "TIMED_WAITING": {Not waiting for any external execution, but independently waiting on its own based on time}; e.g., sleep(), etc. {{ Not in state to be picked by OS scheduler if processing core is available }}
//                                  :=> "TERMINATED" -> {stopped}

// Barrier Synchronization: Mina thread waits for the last running child thread to complete. t_child_x.join([0 | +ve ms wait at most]) on main thread.

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

        // Method 1
        MyThreadRun thr = new MyThreadRun();
        Thread th1 = new Thread(thr);
        th1.start();

        // Method 2 - Not preferred
        MyThreadThread th2 = new MyThreadThread();
        th2.start();

        // Mehtod 3
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Another thread - 2");
            }
        };
        Thread anotherThread2 = new Thread(r2);
        anotherThread2.start();

        // Method 4
        Runnable r3 = () -> System.out.println("Another Thread 3"); // Because Runnable is an interface with a single method. So, we can create a lambda.
        Thread anotherThread3 = new Thread(r3);
        anotherThread3.start();

        // Method 5
        new Thread(() -> System.out.println("Another Thread 4")).start();

        System.out.println("Main Thread Ends...");
    }
}