package strings.reverse_integer;

class Solution {

    // reverse integer
    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
    public int reverse(int x) {
        boolean negative = x < 0;
        long abs = Math.abs((long) x);
        String reversedString = new StringBuilder().append(abs).reverse().toString();
        long reversed = Long.parseLong(reversedString);
        if (negative) reversed = -reversed;
        if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) return 0;
        return (int) reversed;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(-2147483648));
    }
}
