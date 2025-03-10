package iuh.fit.demo5;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Admin 3/10/2025
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        List<Callable<Long>> tasks = List.of(
                () -> sumRangeTask(0, 100000),
                () -> sumRangeTask(100000, 200000),
                () -> sumRangeTask(200000, 300000)
        );

        ExecutorService pool = Executors.newFixedThreadPool(3);
//        ExecutorService pool = Executors.newCachedThreadPool();

        try {
//            pool.invokeAll(tasks)
            List<Future<Long>> fus = pool.invokeAll(tasks);
//            Thread.sleep(1000);
//            pool.submit(() -> sumRangeTask(300000, 400000));
            Future<Long> fu = pool.submit(() -> sumRangeTask(300000, 400000));
            Long total = fus.stream().mapToLong(f -> {
                try {
                    return f.get();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).sum();

            try {
                total += fu.get();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Total: " + total);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }


    public static Long sumRangeTask(int from, int to) {
        System.out.println(Thread.currentThread().getName());
        return LongStream.range(from, to).sum();
    }
}
