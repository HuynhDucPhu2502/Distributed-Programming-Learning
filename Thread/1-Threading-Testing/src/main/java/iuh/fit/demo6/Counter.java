package iuh.fit.demo6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Admin 3/10/2025
 **/
public class Counter {
    private static final ReentrantLock LOCK = new ReentrantLock();
    private int count = 0;

    public void increaseWithoutSync() {
        ++count;
    }

    public synchronized void increaseWithSync() {
        ++count;
    }

    public void increaseWithLock() {
        LOCK.lock();
        try {
            ++count;
        } finally {
            LOCK.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
