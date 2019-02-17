package strings.string_to_integer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {
    public int myAtoi(String str) {
        Pattern pattern = Pattern.compile("^ *([-+]?[0-9]+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String numberAsString = matcher.group(1);
            try {
                return Integer.parseInt(numberAsString);
            } catch (NumberFormatException ex) {
                if (numberAsString.charAt(0) == '-') return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        assertThat(new Solution().myAtoi("   -324 yes"), is(-324));
        assertThat(new Solution().myAtoi("42"), is(42));
        assertThat(new Solution().myAtoi("-42"), is(-42));
        assertThat(new Solution().myAtoi(" words  -324 yes"), is(0));
        assertThat(new Solution().myAtoi(" -91283472332"), is(Integer.MIN_VALUE));
        assertThat(new Solution().myAtoi(" 91283472332"), is(Integer.MAX_VALUE));
    }

}
