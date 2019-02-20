package math.estimate_pi;

import java.util.Random;

public class Solution {

    private Random random = new Random();

    public double estimatePi() {
        int inside = 0;
        int outside = 0;
        for (int i = 0; i < 2_000_0000; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1) {
                inside++;
            } else {
                outside++;
            }
        }
        return 4.0 * inside / (inside + outside);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().estimatePi());
    }

}
