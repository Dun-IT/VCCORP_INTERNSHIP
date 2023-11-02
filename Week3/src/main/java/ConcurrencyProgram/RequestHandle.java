package ConcurrencyProgram;

public class RequestHandle implements Runnable{
    private String name;

    public RequestHandle(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // Begin request
            System.out.println(Thread.currentThread().getName() + " Starting: " + name);
            // Pause 1s
            Thread.sleep(500);
            // End request
            System.out.println(Thread.currentThread().getName() + " Finished: " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
