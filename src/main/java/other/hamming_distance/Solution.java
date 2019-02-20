package other.hamming_distance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/762/
public class Solution {

    public int hammingDistance(int x, int y) {
        int distance = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((x & mask) != (y & mask)) distance++;
            mask <<= 1;
        }
        return distance;
    }

    public static void main(String[] args) {
        assertThat(new Solution().hammingDistance(1, 4), is(2));
        assertThat(new Solution().hammingDistance(1876, 1876), is(0));
    }

}
