package math.rearrange_array;

import com.google.common.collect.Lists;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/rearrange-array/?ref=dash-reco
// Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
// Lets say N = size of the array. Then, following holds true :
// All elements in the array are in the range [0, N-1]
// N * N does not overflow for a signed integer
public class Solution {

    // Arr[i] = Arr[ Arr[i] ]
    public void arrange(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            int current = a.get(i);
            int newValue = a.get(current) % a.size();
            a.set(i, current + newValue * a.size());
        }
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) / a.size());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> myList;

        myList = Lists.newArrayList(4, 0, 2, 1, 3);
        solution.arrange(myList);
        assertThat(myList, is(Lists.newArrayList(3, 4, 2, 0, 1)));

        myList = Lists.newArrayList(1, 0);
        solution.arrange(myList);
        assertThat(myList, is(Lists.newArrayList(0, 1)));
    }
}
