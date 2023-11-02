package ConcurrencyProgram;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        /*
         * Bat dau dong bo hoa
         * 1 khóa, 1 cửa, 5 người,
         * trong 1 khoảng thời gian chỉ 1 người dùng khóa vào cửa,
         * khi rời đi thì để lại khóa
         */
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " - Count: " + count);
        } finally {
            // Ket thuc va giai phong lock
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

public class LockExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Tạo 5 Thread tang dan bien count
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            thread.start();
        }

        // Chờ cho tất cả cac luong ket thuc
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In ra giá trị của counter
        System.out.println("Final Count: " + counter.getCount());
    }
}

