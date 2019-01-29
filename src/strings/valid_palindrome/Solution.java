package strings.valid_palindrome;

// Valid Palindrome
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        String ls = s.toLowerCase();
        while (left < right) {
            while (!isAlphaNum(ls.charAt(left)) && left < right) left++;
            while (!isAlphaNum(ls.charAt(right)) && left < right) right--;
            if (left < right && ls.charAt(left) != ls.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}