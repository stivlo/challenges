package arrays.rotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
public class Solution {
    public int[] solution(int[] a, int k) {
        if (a.length <= 1) return a;
        k = k % a.length;
        reverse(a, 0, a.length - k);
        reverse(a, a.length - k, a.length);
        reverse(a, 0, a.length);
        return a;
    }

    private void reverse(int[] a, int l, int r) {
        for (int i = l; i < (l + r) / 2; i++) swap(a, i, r - i + l - 1);
    }

    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{3, 8, 9, 7, 6}, 3), is(new int[]{9, 7, 6, 3, 8}));
        assertThat(solution.solution(new int[]{}, 3), is(new int[]{}));
    }

}
