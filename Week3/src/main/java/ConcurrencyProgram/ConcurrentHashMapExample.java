package ConcurrencyProgram;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        final int numberOfThreads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(new Task(concurrentMap));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        System.out.println("ConcurrentHashMap: " + concurrentMap);
    }

    static class Task implements Runnable {
        private ConcurrentHashMap<String, Integer> concurrentMap;

        public Task(ConcurrentHashMap<String, Integer> concurrentMap) {
            this.concurrentMap = concurrentMap;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                String key = "Key-" + i;
                int value = (int) (Math.random() * 1000);
                concurrentMap.put(key, value);
            }
        }
    }
}

