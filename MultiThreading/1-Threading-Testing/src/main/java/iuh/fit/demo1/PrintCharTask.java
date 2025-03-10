package iuh.fit.demo1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 3/3/2025
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrintCharTask implements Runnable {
    private char ch;
    private int number;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < number; i++) {
            System.out.print(ch + " ");
        }
    }
}
