package _37SudokuSolver;

public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int n = 1; n <= 9; n++) {
                        char cur = (char) ('0' + n);
                        if (isValid(board, i, j, cur)) {
                            board[i][j] = cur;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char cur) {
        boolean[] values = new boolean[board[0].length];
        for (int jj = 0; jj < board[0].length; jj++) {
            // jj column in row i
            if (board[i][jj] == cur) {
                return false;
            }
        }

        for (int ii = 0; ii < board.length; ii++) {
            // j column in ii row
            if (board[ii][j] == cur) {
                return false;
            }
        }

        int cubXStart = i/3*3;  // 容易错的地方。 i/3表示cube在哪一排,首元素要乘以3
        int cubYStart = j/3*3;
        for (int k = 0; k < 9; k++) {
            int x = cubXStart + k/3;
            int y = cubYStart + k%3;
            if (board[x][y] == cur) {
                return false;
            }
        }
        return true;
    }
}
