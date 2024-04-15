package multithreading.company;

public class Producer extends Thread {
    Company c;

    public Producer(Company c) {
        this.c = c;
    }

    @Override
    public void run() {
        super.run();
        int i = 1;
        while(true) {
            try {
                this.c.produceItem(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
