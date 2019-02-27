package arrays.pascal_triangle_2;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/1660/
public class Solution2 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == -1) return new ArrayList<>();
        List<Integer> prevRow = getRow(rowIndex - 1);
        List<Integer> curRow = new ArrayList<>();
        for (int i = 0; i <= prevRow.size(); i++) {
            if (i == 0 || i == prevRow.size()) curRow.add(1);
            else curRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        return curRow;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().getRow(3));
    }
}
