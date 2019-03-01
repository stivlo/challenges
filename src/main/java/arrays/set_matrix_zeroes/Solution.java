package arrays.set_matrix_zeroes;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.BitSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://www.interviewbit.com/problems/set-matrix-zeros/
public class Solution {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        BitSet zeroRow = new BitSet();
        BitSet zeroCol = new BitSet();
        for (int row = 0; row < a.size(); row++) {
            for (int col = 0; col < a.get(row).size(); col++) {
                if (a.get(row).get(col).equals(0)) {
                    zeroRow.set(row);
                    zeroCol.set(col);
                }
            }
        }
        for (int row = 0; row < a.size(); row++) {
            if (zeroRow.get(row)) zeroRow(a, row);
        }
        for (int col = 0; col < a.get(0).size(); col++) {
            if (zeroCol.get(col)) zeroCol(a, col);
        }

    }

    private void zeroRow(ArrayList<ArrayList<Integer>> a, int row) {
        // set all columns for row 'row' to zero
        for (int i = 0; i < a.get(row).size(); i++) {
            a.get(row).set(i, 0);
        }
    }

    private void zeroCol(ArrayList<ArrayList<Integer>> a, int col) {
        // set all rows for column 'col' to zero
        for (int i = 0; i < a.size(); i++) {
            a.get(i).set(col, 0);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(Lists.newArrayList(1, 0, 1));
        matrix.add(Lists.newArrayList(1, 1, 1));
        matrix.add(Lists.newArrayList(1, 1, 1));
        solution.setZeroes(matrix);
        assertThat(matrix.get(0), is(Lists.newArrayList(0, 0, 0)));
        assertThat(matrix.get(1), is(Lists.newArrayList(1, 0, 1)));
        assertThat(matrix.get(2), is(Lists.newArrayList(1, 0, 1)));

        matrix = new ArrayList<>();
        matrix.add(Lists.newArrayList(0, 0));
        matrix.add(Lists.newArrayList(1, 1));
        assertThat(matrix.get(0), is(Lists.newArrayList(0, 0)));
        assertThat(matrix.get(1), is(Lists.newArrayList(0, 0)));
    }
}
