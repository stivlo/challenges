package arrays.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

// Contains Duplicate
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            if (values.contains(num)) return true;
            values.add(num);
        }
        return false;
    }
}