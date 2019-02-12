package arrays.odd_occurrences;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public class Solution {

    public int solution(int[] nums) {
        int acc = 0;
        for (int num : nums) acc ^= num;
        return acc;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{9, 3, 9, 3, 9, 7 ,9}), is(7));
    }

}
