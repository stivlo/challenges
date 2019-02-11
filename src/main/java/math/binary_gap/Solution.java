package math.binary_gap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
class Solution {
    public int solution(int n) {
        String b = Integer.toBinaryString(n);
        int maxGap = 0;
        int curGap = 0;
        for (int i = 0; i < b.length(); i++) {
            char d = b.charAt(i);
            if (d == '1') {
                if (curGap > maxGap) maxGap = curGap;
                curGap = 0;
            } else {
                curGap++;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        assertThat(s.solution(9), is(2));
        assertThat(s.solution(529), is(4));
        assertThat(s.solution(20), is(1));
        assertThat(s.solution(15), is(0));
        assertThat(s.solution(32), is(0));
    }
}