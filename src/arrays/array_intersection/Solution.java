package arrays.array_intersection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Intersection of Two Arrays II
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersect = new ArrayList<>();
        Map<Integer, Integer> nums1Count = new HashMap<>();
        for (int num : nums1) {
            Integer count = nums1Count.get(num);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            nums1Count.put(num, count);
        }
        for (int num : nums2) {
            Integer count = nums1Count.get(num);
            if (count != null) {
                intersect.add(num);
                count--;
                if (count == 0) {
                    nums1Count.remove(num);
                } else {
                    nums1Count.put(num, count);
                }
            }
        }
        int[] intersectArray = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) {
            intersectArray[i] = intersect.get(i);
        }
        return intersectArray;
    }

}
