package arrays.pascal_triangle_2;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/1660/
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        return getRow(rowIndex, result);
    }

    private List<Integer> getRow(int rowIndex, List<Integer> prevRow) {
        if (prevRow.size() == rowIndex + 1) return prevRow;
        List<Integer> nextRow = new ArrayList<>();
        for (int i = 0; i <= prevRow.size(); i++) {
            if (i == 0 || i == prevRow.size()) nextRow.add(1);
            else nextRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        return getRow(rowIndex, nextRow);
    }

}
