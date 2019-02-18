package other.pascal_triangle;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/601/
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> curRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                curRow.add(computeCell(prevRow, col));
            }
            prevRow = curRow;
            res.add(curRow);
        }
        return res;
    }

    private int computeCell(List<Integer> prevRow, int col) {
        if (col == 0 || col == prevRow.size()) {
            return 1;
        }
        return prevRow.get(col - 1) + prevRow.get(col);
    }

}
