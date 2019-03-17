package math.pow_of_2_int;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/power-of-two-integers/
public class Solution {

    public int isPower(int a) {
        if (a == 1) return 1;
        int divisor = 2;
        List<Integer> times = new ArrayList<>();
        int curTimes = 0;
        int limit = (int) Math.sqrt(a);
        while (a >= 1 && divisor <= limit) {
            if (a % divisor == 0) {
                curTimes++;
                a /= divisor;
            } else {
                divisor++;
                if (curTimes > 0) {
                    times.add(curTimes);
                }
                curTimes = 0;
            }
        }
        if (a > 1) return 0;
        if (curTimes > 1) {
            times.add(curTimes);
        }
        if (times.isEmpty()) return 0;
        if (times.get(0) <= 1) return 0;
        int min = min(times);
        for (int curDiv = 2; curDiv <= min; curDiv++) {
            boolean dividesAll = true;
            for (Integer time : times) {
                if (time % curDiv > 0) dividesAll = false;
            }
            if (dividesAll) return 1;
        }
        return 0;
    }

    private int min(List<Integer> nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) min = num;
        }
        return min;
    }

    @Test
    void returnsTrueFor1() {
        assertThat(isPower(1), is(1));
    }

    @Test
    void returnsFalseFor3() {
        assertThat(isPower(3), is(0));
    }

    @Test
    void returnsTrueFor4() {
        assertThat(isPower(4), is(1));
    }

    @Test
    void returnsTrueFor36() {
        assertThat(isPower(36), is(1));
    }

    @Test
    void returnFalseFor72() {
        assertThat(isPower(72), is(0));
    }

    @Test
    void returnsTrueFor1024000000() {
        assertThat(isPower(1_024_000_000), is(1));
    }

    @Test
    void returnsFalseFor7988() {
        assertThat(isPower(7988), is(0));
    }
}
