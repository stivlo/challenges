package search;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/774/
public class Solution {

    private int firstBadVersion;

    public Solution(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public int firstBadVersion(int n) {
        long maxGood = 0;
        long minBad = n + 1L;
        while (minBad - maxGood > 1) {
            long mid = (maxGood + minBad) / 2L;
            if (isBadVersion((int) mid)) {
                minBad = mid;
            } else {
                maxGood = mid;
            }
        }
        return (int) minBad;
    }

    private boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public static void main(String[] args) {
        int n = 2147483647;
        int firstBadVersion= 2147483647;
        System.out.println("found: " + new Solution(firstBadVersion).firstBadVersion(n));
    }

}