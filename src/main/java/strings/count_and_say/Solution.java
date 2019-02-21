package strings.count_and_say;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/886/
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
public class Solution {

    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int pos = 0;
            char prevChar = res.charAt(0);
            char curChar;
            int curCount = 0;
            while (pos < res.length()) {
                curChar = res.charAt(pos);
                if (curChar == prevChar) {
                    curCount++;
                } else {
                    next.append(curCount).append(prevChar);
                    prevChar = curChar;
                    curCount = 1;
                }
                pos++;
            }
            next.append(curCount).append(prevChar);
            res = next.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.countAndSay(1), is("1"));
        assertThat(solution.countAndSay(2), is("11"));
        assertThat(solution.countAndSay(3), is("21"));
        assertThat(solution.countAndSay(4), is("1211"));
        assertThat(solution.countAndSay(5), is("111221"));
    }
}
