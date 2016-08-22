package _36ValidSudoku;

public class Solution {
    public boolean isValidSudoku(char[][] b) {
        for(int i = 0; i < 9; i++) {
            // valid ith row, ith column, cube that i belongs
            // 123456789
            // 123456789
            // 123456789
            // ..
            // pivot = <1,1>, <2,2>, <3,3>, ...
            // if (i = 0), pivot = <1,1>.  check the 1st row, 1st column, 1st cube
            boolean[] row = new boolean[10];
            boolean[] column = new boolean[10];
            boolean[] cube = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (b[i][j] != '.') {
                    int value = b[i][j] - '1';
                    if (column[value]) {  // the value appears before, invalid!
                        return false;
                    }
                    column[value] = true;
                }
                if (b[j][i] != '.') {
                    int value = b[j][i] - '1';
                    if (row[value]) {  // the value appears before, invalid!
                        return false;
                    }
                    row[value] = true;
                }

                int blockXStart = (i/3) * 3;
                int blockYStart = (i%3) * 3;
                int xIndexForCube = blockXStart + j/3;
                int yIndexForCube = blockYStart + j%3;
                if (b[xIndexForCube][yIndexForCube] != '.') {
                    int valueInCube = b[xIndexForCube][yIndexForCube] - '1';
                    if (cube[valueInCube]) {
                        return false;
                    }
                    cube[valueInCube] = true;
                }
            }

        }
        return true;
    }
}
