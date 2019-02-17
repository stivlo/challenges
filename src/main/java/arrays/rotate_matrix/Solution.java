package arrays.rotate_matrix;

import java.util.Arrays;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
class Solution {

    public void rotate(int[][] a) {
        int len = a.length;
        int last = a.length - 1;
        for (int layer = 0; layer < len / 2; layer++) {
            for (int rot = 0; rot < last - 2 * layer; rot++) {
                visualiseTopRightBottomLeft(len, layer, rot);
                swap(a, getTopLeft(last, layer, rot), getTopRight(last, layer, rot));
                swap(a, getTopLeft(last, layer, rot), getBottomRight(last, layer, rot));
                swap(a, getTopLeft(last, layer, rot), getBottomLeft(last, layer, rot));
            }
        }
        System.out.println();
    }

    private Coord getTopLeft(int last, int layer, int rot) {
        return new Coord(layer, layer + rot);
    }

    private Coord getTopRight(int last, int layer, int rot) {
        return new Coord(layer + rot, last - layer);
    }

    private Coord getBottomRight(int last, int layer, int rot) {
        return new Coord(last - layer, last - layer - rot);
    }

    private Coord getBottomLeft(int last, int layer, int rot) {
        return new Coord(last - layer - rot, layer);
    }

    private void swap(int[][] a, Coord first, Coord second) {
        int firstCell = a[first.row][first.col];
        a[first.row][first.col] = a[second.row][second.col];
        a[second.row][second.col] = firstCell;
    }

    private void setCharAtCoord(char[][] a, Coord coord, char letter) {
        a[coord.row][coord.col] = letter;
    }

    public static void main(String[] args) {
        rotateAndPrint(createMatrixWithSize(5));
    }

    private void visualiseTopRightBottomLeft(int len, int layer, int rot) {
        char[][] a = new char[len][len];
        for (int curRow = 0; curRow < len; curRow++) {
            for (int curCol = 0; curCol < len; curCol++) {
                a[curRow][curCol] = '_';
            }
        }
        int last = len - 1;
        setCharAtCoord(a, getTopLeft(last, layer, rot), '1');
        setCharAtCoord(a, getTopRight(last, layer, rot), '2');
        setCharAtCoord(a, getBottomRight(last, layer, rot), '3');
        setCharAtCoord(a, getBottomLeft(last, layer, rot), '4');
        System.out.printf("%nLayer %d, Rotation %d:%n", layer, rot);
        Arrays.stream(a).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    private static int[][] createMatrixWithSize(int size) {
        int[][] a = new int[size][size];
        int count = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                a[row][col] = ++count;
            }
        }
        return a;
    }

    private static void rotateAndPrint(int[][] matrix) {
        Solution sol = new Solution();
        sol.rotate(matrix);
        Arrays.stream(matrix).forEach(r -> System.out.println(Arrays.toString(r)));
    }

    private class Coord {
        int row;
        int col;

        Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
