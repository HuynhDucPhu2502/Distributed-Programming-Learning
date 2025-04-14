package iuh.fit.demo4;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Admin 3/3/2025
 **/
public class FourthDemo {
    public static void main(String[] args) {
        Callable<Long> sumTask1 = () -> (long) IntStream.rangeClosed(0, 1000).sum();
        Callable<Long> sumTask2 = () -> (long) IntStream.rangeClosed(1000, 2000).sum();
        Callable<Long> sumTask3 = () -> (long) IntStream.rangeClosed(2000, 3001).sum();

        FutureTask<Long> fu1 = new FutureTask<>(sumTask1);
        FutureTask<Long> fu2 = new FutureTask<>(sumTask2);
        FutureTask<Long> fu3 = new FutureTask<>(sumTask3);

        Thread thread1 = new Thread(fu1);
        Thread thread2 = new Thread(fu2);
        Thread thread3 = new Thread(fu3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Long total = fu1.get() + fu2.get() + fu3.get();
            System.out.println(total);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
