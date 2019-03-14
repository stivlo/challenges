package math.reverse_integer;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    public int reverse(int a) {
        int sign = a >= 0 ? 1 : -1;
        a *= sign;
        long reversed = 0;
        do {
            reversed *= 10;
            reversed += a % 10;
            a = a / 10;
        } while (a != 0);
        reversed *= sign;
        if (sign > 0 && reversed > Integer.MAX_VALUE) {
            return 0;
        } else if (sign < 0 && reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;
    }

    @Test
    void smallPositiveNumberReverseWorks() {
        assertThat(reverse(123), is(321));
    }

    @Test
    void smallNegativeNumberReverseWorks() {
        assertThat(reverse(-123), is(-321));
    }

    @Test
    void bigPositiveNumberOverflowsAndReturnsZero() {
        assertThat(reverse(1000_000_007), is(0));
    }

    @Test
    void bigNegativeNumberOverflowsAndReturnsZero() {
        assertThat(reverse(-1000_000_007), is(0));
    }

}
