package arrays.spiral_order_matrix;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

// https://www.interviewbit.com/problems/spiral-order-matrix-i/
public class Solution {

    public ArrayList<Integer> spiralOrder(final List<List<Integer>> a) {
        ArrayList<Integer> res = new ArrayList<>();
        int dir = 0;
        int startCol = 0;
        int endRow = a.size() - 1;
        if (endRow < 0) return new ArrayList<>();
        int endCol = a.get(0).size() - 1;
        int startRow = 0;
        while ((endRow - startRow) >= 0 && (endCol - startCol) >= 0) {
            if (dir == 0) {
                for (int col = startCol; col <= endCol; col++) {
                    res.add(a.get(startRow).get(col));
                }
                startRow++;
            } else if (dir == 1) {
                for (int row = startRow; row <= endRow; row++) {
                    res.add(a.get(row).get(endCol));
                }
                endCol--;
            } else if (dir == 2) {
                for (int col = endCol; col >= startCol; col--) {
                    res.add(a.get(endRow).get(col));
                }
                endRow--;
            } else if (dir == 3) {
                for (int row = endRow; row >= startRow; row--) {
                    res.add(a.get(row).get(startCol));
                }
                startCol++;
            }
            dir = (dir + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> myList = new ArrayList<>();
        myList.add(ImmutableList.of(133, 241,  22, 258, 187, 150,  79, 207, 196, 401, 366, 335, 198));
        myList.add(ImmutableList.of(401,  55, 260, 363,  14, 318, 178, 296, 333, 296,  45,  37,  10));
        myList.add(ImmutableList.of(112, 374,  79,  12,  97,  39, 310, 223, 139,  91, 171,  95, 126));
        System.out.println(solution.spiralOrder(myList));
    }
}
