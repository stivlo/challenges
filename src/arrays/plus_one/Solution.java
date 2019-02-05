package arrays.plus_one;

// plus one
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
public class Solution {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] > 9) {
                digits[i] -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry > 0) {
            int solution[] = new int[digits.length + 1];
            solution[0] = 1;
            System.arraycopy(digits, 0, solution, 1, digits.length);
            return solution;
        }
        return digits;
    }

}
