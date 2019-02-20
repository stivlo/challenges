package other.valid_parenthesis;

import java.util.Deque;
import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/721/
public class Solution {

    private static final String OPEN = "([{";
    private static final String CLOSE = ")]}";

    public boolean isValid(String s) {
        Deque<Integer> parenthesis = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            int pos = OPEN.indexOf(s.charAt(i));
            if (pos != -1) {
                parenthesis.addFirst(pos);
            } else {
                pos = CLOSE.indexOf(s.charAt(i));
                if (parenthesis.isEmpty()) return false;
                if (!parenthesis.removeFirst().equals(pos)) return false;
            }
        }
        return parenthesis.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.isValid(""), is(true));
        assertThat(solution.isValid("()"), is(true));
        assertThat(solution.isValid("()[]{}"), is(true));
        assertThat(solution.isValid("(]"), is(false));
        assertThat(solution.isValid("([(]"), is(false));
        assertThat(solution.isValid("{[]}"), is(true));
        assertThat(solution.isValid("["), is(false));
    }

}
