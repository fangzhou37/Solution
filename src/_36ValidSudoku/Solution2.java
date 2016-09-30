package _36ValidSudoku;

public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {   // i would be row#, col#, block#
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] block = new boolean[9];
            for (int j = 0; j < 9; j++) {   // all j columns of row i
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[num]) {
                        return false;
                    }
                    row[num] = true;
                }
            }

            for (int j = 0; j < 9; j++) {   // all j rows of column i
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (col[num]) {
                        return false;
                    }
                    col[num] = true;
                }
            }

            int startRowOfThisBlock = i/3*3;
            int startColOfThisBlock = i%3*3;
            for (int j = 0; j < 9; j++) {   // all j columns of row i
                int x = startRowOfThisBlock + j/3;
                int y = startColOfThisBlock + j%3;
                if (board[x][y] != '.') {
                    int num = board[x][y] - '1';
                    if (block[num]) {
                        return false;
                    }
                    block[num] = true;
                }
            }
        }
        return true;
    }
}
