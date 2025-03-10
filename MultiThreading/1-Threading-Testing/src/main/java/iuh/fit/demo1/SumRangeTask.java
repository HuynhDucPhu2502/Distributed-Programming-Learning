package iuh.fit.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Admin 3/3/2025
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumRangeTask implements Runnable {
    private int from;
    private int to;

    @Override
    public void run() {
        int sum = 0;
        for (int i = from; i <= to; i++) sum += i;
        System.out.println("Total: " + sum);
    }
}
