package other.reverse_bits;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/648/
public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int destMask = 1;
        for (int i = 31; i >= 0; i--) {
            int sourceMask = 1 << i;
            if ((n & sourceMask) != 0) {
                res |= destMask;
            }
            destMask <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 << 31);
    }

}