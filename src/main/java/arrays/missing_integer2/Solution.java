package arrays.missing_integer2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
public class Solution {

    public int solution(int[] a) {
        for (int i = 0; i < a.length; i++) {
            while (a[i] > 0 && a[i] <= a.length && a[i] != a[a[i] - 1] && a[i] != i + 1) swap(a, i, a[i] - 1);
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != i + 1) return i + 1;
        }
        return a.length + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        assertThat(new Solution().solution(new int[]{1, 3, 6, 4, 1, 2}), is(5));
        assertThat(new Solution().solution(new int[]{1, 2, 3}), is(4));
        assertThat(new Solution().solution(new int[]{-1, -2}), is(1));
    }

}
