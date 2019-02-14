package arrays.valid_sudoku;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) return false;
            if (!isValidCol(board, i)) return false;
        }
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isValidSquare(board, row, col)) return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        int[] nums = new int[10];
        for (int col = 0; col < 9; col++) {
            char cell = board[row][col];
            if (cell != '.') {
                nums[cell - '0']++;
                if (nums[cell - '0'] > 1) return false;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        int[] nums = new int[10];
        for (int row = 0; row < 9; row++) {
            char cell = board[row][col];
            if (cell != '.') {
                nums[cell - '0']++;
                if (nums[cell - '0'] > 1) return false;
            }
        }
        return true;
    }

    private boolean isValidSquare(char[][] board, int srow, int scol) {
        int[] nums = new int[10];
        for (int row = srow; row < srow + 3; row++) {
            for (int col = scol; col < scol + 3; col++) {
                char cell = board[row][col];
                if (cell != '.') {
                    nums[cell - '0']++;
                    if (nums[cell - '0'] > 1) return false;
                }
            }
        }
        return true;
    }

}
