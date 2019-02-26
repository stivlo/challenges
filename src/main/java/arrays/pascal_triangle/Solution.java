package arrays.pascal_triangle;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/pascal-triangle/
public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> prev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> next = computeNextRow(prev);
            res.add(next);
            prev = next;
        }
        return res;
    }


    private ArrayList<Integer> computeNextRow(ArrayList<Integer> prev) {
        ArrayList<Integer> next = new ArrayList<>();
        for (int i = 0; i <= prev.size(); i++) {
            next.add(computeNextElement(prev, i));
        }
        return next;
    }

    private int computeNextElement(ArrayList<Integer> prev, int i) {
        if (i == 0 || i == prev.size()) return 1;
        return prev.get(i - 1) + prev.get(i);
    }

}
