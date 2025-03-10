package iuh.fit.demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Admin 3/10/2025
 **/
public class DemoParking {
    private static final int CAPACITY = 5;
    private static ParkingGarage parkingGarage = new ParkingGarage(5);
    public static void main(String[] args) {
        Runnable enterTask = () -> parkingGarage.enter();
        Runnable leaveTask = () -> {
            try {
                Thread.sleep(2000);
                parkingGarage.leave();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < CAPACITY; ++i) {
            pool.submit(enterTask);
        }

        for (int i = 0; i < CAPACITY; ++i) {
            pool.submit(leaveTask);
        }

        pool.submit(enterTask);
        pool.submit(enterTask);
        pool.submit(enterTask);
        pool.submit(enterTask);
        pool.submit(enterTask);
        pool.submit(enterTask);
        pool.submit(enterTask);
        pool.submit(enterTask);
        pool.submit(enterTask);
        pool.shutdown();

    }
}
