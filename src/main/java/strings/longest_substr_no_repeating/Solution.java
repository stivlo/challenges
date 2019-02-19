package strings.longest_substr_no_repeating;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Solution {

    // brute force
    public int lengthOfLongestSubstringBrute(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> visited = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char curChar = s.charAt(j);
                if (visited.contains(curChar)) {
                    break;
                }
                visited.add(curChar);
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    // sliding window
    public int lengthOfLongestSubstring(String s) {
        int lo = 0;
        int hi = 0;
        int maxLen = 0;
        Set<Character> seen = new HashSet<>();
        while (lo < s.length() && hi < s.length()) {
            Character curChar = s.charAt(hi);
            if (!seen.contains(curChar)) {
                maxLen = Math.max(maxLen, hi - lo + 1);
                seen.add(curChar);
                hi++;
            } else {
                seen.remove(s.charAt(lo));
                lo++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        assertThat(new Solution().lengthOfLongestSubstring("aab"), is(2));
        assertThat(new Solution().lengthOfLongestSubstring(""), is(0));
        assertThat(new Solution().lengthOfLongestSubstring(" "), is(1));
        assertThat(new Solution().lengthOfLongestSubstring("abcabcbb"), is(3));
        assertThat(new Solution().lengthOfLongestSubstring("bbbbb"), is(1));
        assertThat(new Solution().lengthOfLongestSubstring("pwwkew"), is(3));
    }
}
