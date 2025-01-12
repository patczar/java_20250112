package p06_util_concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All threads reached the barrier"));

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting at barrier");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}