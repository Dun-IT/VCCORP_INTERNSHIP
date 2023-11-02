package ConcurrencyProgram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        // 1 Pool, 1 Thread xu ly tuan tu
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
