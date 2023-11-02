package ConcurrencyProgram;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Tăng giá trị của atomicInt
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInt.incrementAndGet(); // Tăng giá trị một cách an toàn
                    System.out.println(atomicInt.get());
                }
            });
            thread.start();
        }

        // Chờ cho tất cả các luồng kết thúc
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In ra giá trị cuối cùng của atomicInt
        System.out.println("Final Value: " + atomicInt.get());
    }
}

