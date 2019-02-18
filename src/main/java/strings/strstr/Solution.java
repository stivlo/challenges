package strings.strstr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/885/
class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        final int lastNeedlePos = needle.length() - 1;
        for  (int pos = lastNeedlePos; pos < haystack.length(); pos++) {
            for (int needlePos = lastNeedlePos; needlePos >= 0 &&
                    haystack.charAt(pos - lastNeedlePos + needlePos) == needle.charAt(needlePos); needlePos--) {
                if (needlePos == 0) return pos - lastNeedlePos;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        assertThat(new Solution().strStr("hello", ""), is(0));
        assertThat(new Solution().strStr("hello", "ll"), is(2));
        assertThat(new Solution().strStr("hello worlds", "ld"), is(9));
        assertThat(new Solution().strStr("pattern", "not found at all"), is(-1));
    }

}