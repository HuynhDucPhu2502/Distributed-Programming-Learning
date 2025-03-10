package iuh.fit.demo3;

/**
 * Admin 3/3/2025
 **/
public class ThirdDemoThread {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName() + " Excute " + "Hello World");
        };

        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());

        Thread thread1 = new Thread(task1, "Thread 1");
        System.out.println("Main thread before set: " + Thread.currentThread().getPriority());
        System.out.println("Prior thread 1: " + thread1.getPriority());
        Thread.currentThread().setPriority(7);
        System.out.println("Main thread after set: " + Thread.currentThread().getPriority());
        Thread thread2 = new Thread(task1, "Thread 2");
        System.out.println("Prior thread 2 before set: " + thread2.getPriority());
        thread2.setPriority(2);
        System.out.println("Prior thread 2 after set: " + thread2.getPriority());
        System.out.println("Thread 1 before starting " + thread1.getState());
        thread1.start();
        System.out.println("Thread 1 after starting " + thread1.getState());

        try {
            thread1.join();
            System.out.println("Thread 1 done " + thread1.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
