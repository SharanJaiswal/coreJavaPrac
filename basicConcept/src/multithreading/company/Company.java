/*
Produce will not produce anything until it is picked by consumer.
Consumer will not consume anything until anything is produced by producer.
Produced item will be kept in the variable n.
 */


package multithreading.company;

public class Company {
    // if there is value in below variable, then produced is present.
    int n;

    // false: chance of Producer
    // true: chance of Consumer
    Boolean chance = false;

    // We are using synchronized because we do not want both methods to run asynchronously
    synchronized public void produceItem(int n) throws InterruptedException {
        if(chance) { wait(); }
        this.n = n;
        System.out.println("Produced : " + this.n);

        chance = true;
        notify();
    }

    synchronized public int consumeItem() throws InterruptedException {
        if(!chance) { wait(); }
        System.out.println("Consumed : " + this.n);

        chance = false;
        notify();

        return this.n;
    }
}
