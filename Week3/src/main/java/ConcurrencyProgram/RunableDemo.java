package ConcurrencyProgram;

public class RunableDemo implements Runnable{
    private Thread t;
    private String threadName;

    public RunableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exiting " + threadName);
    }

    public static void main(String[] args) {
        RunableDemo runableDemo1 = new RunableDemo("Thread - 1");
        RunableDemo runableDemo2 = new RunableDemo("Thread - 2");
        Thread t1 = new Thread(runableDemo1);
        Thread t2 = new Thread(runableDemo2);
        t1.start();
        t2.start();
    }
}
