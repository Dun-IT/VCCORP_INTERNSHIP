package ConcurrencyProgram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // Call 100 request
        for (int i = 0; i < 100; i++) {
            executorService.execute(new RequestHandle("Request-" + i));
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
    }
}
