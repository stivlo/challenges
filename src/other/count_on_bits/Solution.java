package other.count_on_bits;

// number of 1 bits
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/565/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int b = 1;
        int nBits = 0;
        for (int i = 1; i <= 32; i++) {
            if ((b & n) != 0) nBits++;
            b = b << 1;
        }
        return nBits;
    }
}