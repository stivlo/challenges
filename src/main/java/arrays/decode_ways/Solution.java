package arrays.decode_ways;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://leetcode.com/problems/decode-ways/
class Solution {
    public int numDecodings(String s) {
        Map<String, Integer> waysMap = new HashMap<>();
        return numDecodings(s, waysMap);
    }

    private int numDecodings(String s, Map<String, Integer> waysMap) {
        if (s.length() == 0) return 1;
        Integer memoWays = waysMap.get(s);
        if (memoWays != null) return  memoWays;
        int nWays = 0;
        if (s.charAt(0) == '0') return 0;
        nWays += numDecodings(s.substring(1), waysMap);
        int num = extractTwoCharCode(s);
        if (num > 0 && num < 27) nWays += numDecodings(s.substring(2), waysMap);
        waysMap.put(s, nWays);
        return nWays;
    }

    private int extractTwoCharCode(String s) {
        if (s.length() < 2) return 0;
        return Integer.parseInt(s.substring(0, 2));
    }

    public static void main(String[] args) {
        assertThat(new Solution().numDecodings("101"), is(1));
        assertThat(new Solution().numDecodings(""), is(1));
        assertThat(new Solution().numDecodings("0"), is(0));
        assertThat(new Solution().numDecodings("01"), is(0));
        assertThat(new Solution().numDecodings("10"), is(1));
        assertThat(new Solution().numDecodings("12"), is(2));
        assertThat(new Solution().numDecodings("121"), is(3));
        assertThat(new Solution().numDecodings("226"), is(3));
    }
}