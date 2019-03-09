package math.nums_len_and_value;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
public class Solution {

    public int solve(ArrayList<Integer> availDigits, int numLen, int limit) {
        List<Integer> limitDigits = extractDigits(limit);
        // case 1: limit number is too small and any number of numLen would be bigger
        if (limitDigits.size() < numLen) {
            return 0;
        }
        // case 2: if len(limit) > numLen -> all possible combinations of length B are valid
        if (limitDigits.size() > numLen) {
            boolean isZero = isDigitPresent(availDigits, 0);
            if (isZero && numLen > 1) {
                return (availDigits.size() - 1) * ((int) Math.pow(availDigits.size(), numLen - 1));
            } else {
                return (int) Math.pow(availDigits.size(), numLen);
            }
        }
        // case 3: numLen == len(limit)
        return calculate(availDigits, limitDigits, 0, numLen);
    }

    private boolean isDigitPresent(ArrayList<Integer> digits, int num) {
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i) == num) {
                return true;
            }
        }
        return false;
    }

    private int calculate(ArrayList<Integer> availDigits, List<Integer> limitDigits, int index, int numLen) {
        if (index == numLen) {
            return 0;
        }
        int usableDigitsCount = countUsableDigits(availDigits, limitDigits, index, numLen);
        int result = usableDigitsCount * ((int) Math.pow(availDigits.size(), numLen - index - 1));
        boolean isPresent = isDigitPresent(availDigits, limitDigits.get(index));
        if (isPresent) {
            result += calculate(availDigits, limitDigits, index + 1, numLen);
        }
        return result;
    }

    private int countUsableDigits(List<Integer> availDigits, List<Integer> limitDigits, int index, int numLen) {
        int lowerCount = 0;
        for (int availDigit : availDigits) {
            if (availDigit < limitDigits.get(index)) {
                if (availDigit != 0 || index != 0 || numLen <= 1) {
                    lowerCount++;
                }
            }
        }
        return lowerCount;
    }

    /**
     * build an array of digits from the number argument,
     * for instance extractDigits(325) returns [3, 2, 5]
     */
    private List<Integer> extractDigits(int number) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (number != 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.extractDigits(325), is(Lists.newArrayList(3, 2, 5)));

        assertThat(solution.countUsableDigits(Lists.newArrayList(0, 1), Lists.newArrayList(2, 3, 5), 0, 1), is(2));
        assertThat(solution.countUsableDigits(Lists.newArrayList(0, 1), Lists.newArrayList(2, 3, 5), 0, 2), is(1));
        assertThat(solution.countUsableDigits(Lists.newArrayList(0, 1), Lists.newArrayList(2, 3, 5), 1, 2), is(2));

        // case 1
        // assertThat(solution.solve(Lists.newArrayList(0, 4, 7), 4, 28), is(0));

        // case 2
        assertThat(solution.solve(Lists.newArrayList(0, 4, 7), 4, 12345), is(2 * 3 * 3 * 3));

        // case 3
        assertThat(solution.solve(Lists.newArrayList(0, 1, 2, 5), 2, 21), is(5));
        assertThat(solution.solve(Lists.newArrayList(2, 9), 5, 17015), is(0));
    }


}