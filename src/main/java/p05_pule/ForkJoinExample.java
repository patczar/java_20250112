package p05_pule;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {
    static class SumTask extends RecursiveTask<Integer> {
        private final int[] array;
        private final int start, end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 2) {
                int sum = 0;
                for (int i = start; i < end; i++) sum += array[i];
                return sum;
            }

            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            leftTask.fork();
            return rightTask.compute() + leftTask.join();
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new SumTask(array, 0, array.length));
        System.out.println("Sum: " + result);
    }
}