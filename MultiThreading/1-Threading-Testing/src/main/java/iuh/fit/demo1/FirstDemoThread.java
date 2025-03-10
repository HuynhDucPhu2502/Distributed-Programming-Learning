package iuh.fit.demo1;

/**
 * Admin 3/3/2025
 **/
public class FirstDemoThread {
    public static void main(String[] args) {
        Runnable printCharTaskA = new PrintCharTask('A', 10);
        Runnable sumRangeTask = new SumRangeTask(1, 10);
        Runnable printCharTaskB = new PrintCharTask('B', 10);

        Thread thread1 = new Thread(printCharTaskA, "Thread 1");
        Thread thread2 = new Thread(sumRangeTask, "Thread 2");
        Thread thread3 = new Thread(printCharTaskB, "Thread 3");
        // Gọi .start() để bắt đầu một thread mới thực sự, chạy song song với các thread khác.
        // Nếu gọi .run() thay vì .start(), phương thức run() sẽ chạy trên thread hiện tại
        // thay vì tạo một thread mới, tức là nó không thực sự chạy song song.
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
