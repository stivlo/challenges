package arrays.min_steps_inf_grid;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
public class Solution {

    public int coverPoints(List<Integer> x, List<Integer> y) {
        int steps = 0;
        if (x.isEmpty()) return 0;
        int currX = x.get(0);
        int currY = y.get(0);
        for (int i = 1; i < x.size(); i++) {
            int destX = x.get(i);
            int destY = y.get(i);
            int deltaX = Math.abs(destX - currX);
            int deltaY = Math.abs(destY - currY);
            steps += Math.min(deltaX, deltaY);
            steps += Math.abs(deltaX - deltaY);
            currX = destX;
            currY = destY;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.coverPoints(ImmutableList.of(), ImmutableList.of()), is(0));
        assertThat(solution.coverPoints(ImmutableList.of(0, 1, 1), ImmutableList.of(0, 1, 2)), is(2));
    }

}
