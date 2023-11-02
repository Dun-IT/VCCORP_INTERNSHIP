package ConcurrencyProgram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // Call 100 request
        for (int i = 0; i < 100; i++) {
            executorService.execute(new RequestHandle("Request-" + i));
        }
        // Close executor
        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }
    }
}
