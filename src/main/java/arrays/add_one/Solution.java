package arrays.add_one;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/add-one-to-number/
public class Solution {

    public int[] plusOne(int[] a) {
        int carry = addOneToExistingArray(a);
        int leadingZeroes = carry == 0 ? countLeadingZeroes(a) : 0;
        int newSize = a.length - leadingZeroes + carry;
        if (newSize == a.length) return a;
        int[] b = new int[newSize];
        if (carry > 0) b[0] = carry;
        for (int i = carry; i < newSize; i++) {
            b[i] = a[i - carry + leadingZeroes];
        }
        return b;
    }

    private int addOneToExistingArray(int[] a) {
        a[a.length - 1]++;
        int carry = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            a[i] += carry;
            if (a[i] > 9) {
                a[i] -= 10;
                carry = 1;
            } else carry = 0;
        }
        return carry;
    }

    private int countLeadingZeroes(int[] a) {
        int leadingZeroes = 0;
        for (int item : a) {
            if (item == 0) leadingZeroes++;
            else break;
        }
        return leadingZeroes;
    }

    @Test
    void addOneTo123() {
        assertThat(plusOne(new int[]{1, 2, 3}), is(new int[]{1, 2, 4}));
    }

    @Test
    void addOneTo999() {
        assertThat(plusOne(new int[]{9, 9, 9}), is(new int[]{1, 0, 0, 0}));
    }

    @Test
    void addOneTo0099() {
        assertThat(plusOne(new int[]{0, 0, 9, 9}), is(new int[]{1, 0, 0}));
    }

}
