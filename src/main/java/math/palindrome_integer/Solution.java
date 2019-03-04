package math.palindrome_integer;

public class Solution {

    public int isPalindrome(int a) {
        if (a < 0) return 0;
        int reversed = 0;
        int b = a;
        while (b > 0) {
            int remainder = b % 10;
            b /= 10;
            reversed = (reversed * 10) + remainder;
        }
        if (a == reversed) return 1;
        else return 0;
    }
    
}
