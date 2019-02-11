package strings.first_unique;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/881/
class Solution {

    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) if (freq[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.firstUniqChar("leetcode"), is(0));
        assertThat(solution.firstUniqChar("loveleetcode"), is(2));
    }

}
