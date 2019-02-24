package recursion.reverse_string;

// https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
public class Solution {

    public void reverseString(char[] s) {
        reverseString(s, 0);
    }

    private void reverseString(char[] s, int index) {
        if (index >= s.length / 2) return;
        swap(s, index, s.length - 1 - index);
        reverseString(s, index + 1);
    }

    private void swap(char[] s, int i, int j) {
        char charAtI = s[i];
        s[i] = s[j];
        s[j] = charAtI;
    }

}
