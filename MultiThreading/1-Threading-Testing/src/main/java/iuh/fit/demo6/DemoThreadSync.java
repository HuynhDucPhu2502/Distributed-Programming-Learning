package iuh.fit.demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Admin 3/10/2025
 **/
public class DemoThreadSync {
    private static Counter counter = new Counter();

    public static void main(String[] args) throws Exception {
        Runnable task = () -> {
            IntStream.range(0, 1000).forEach(t -> {
//                counter.increaseWithoutSync();
                counter.increaseWithSync();
            });
        };

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);


        pool.shutdown();

        while (!pool.isTerminated()) {}
        System.out.println("Counter: " + counter.getCount());
    }
}
