package Snapchat2.TicTacToe;

public class Solution {
    private int[][] board;

    public Solution(int n) {
        board = new int[n][n];
    }

    public boolean valid() {
        int diagRes = 3;
        int oppositeDiagRes = 3;
        for (int i = 0; i < board.length; i++) {
            int rowRes = 3;    // binary : 000...00011
            int colRes = 3;    // binary : 000...00011
            for (int j = 0; j < board[0].length; j++) {
                // 行
                if (board[i][j] == 0) {
                    rowRes = 0;
                }
                if (board[i][j] == 1) {
                    rowRes &= 1;
                }
                if (board[i][j] == -1) {
                    rowRes &= 2;
                }

                // 列
                if (board[j][i] == 0) {
                    colRes = 0;
                }
                if (board[j][i] == 1) {
                    colRes &= 1;
                }
                if (board[j][i] == -1) {
                    colRes &= 2;
                }
            }
            if ((rowRes & 3) != 0 || (colRes & 3) != 0) {
                return false;
            }

            // 对角线
            if (board[i][i] == 0) {
                diagRes = 0;
            }
            if (board[i][i] == 1) {
                diagRes &= 1;
            }
            if (board[i][i] == -1) {
                diagRes &= 2;
            }

            if (board[i][board.length - i - 1] == 0) {
                oppositeDiagRes = 0;
            }
            if (board[i][board.length - i - 1] == 1) {
                oppositeDiagRes &= 1;
            }
            if (board[i][board.length - i - 1] == -1) {
                oppositeDiagRes &= 2;
            }
        }
        if ((diagRes & 3) != 0 || (oppositeDiagRes & 3) != 0) {
            return false;
        }
        return true;
    }

    static class MoveStatus {
        boolean win;
        int row;
        int col;

        public MoveStatus(boolean win, int row, int col) {
            this.win = win;
            this.row = row;
            this.col = col;
        }
    }

    public MoveStatus nextMove(int curChess) {
        for (int col = 0; col < board[0].length; col++) {
            int row = board.length-1;
            for (; row >= 0; row--) {
                if (board[row][col] == 0) {
                    break;
                }
            }
            if (row < 0) {  // cannot find any open position in this col
                continue;
            }
            board[row][col] = curChess;
            if (!valid()) {
                return new MoveStatus(true, row, col);
            }
            MoveStatus competeMoveStatus = nextMove(-curChess);
            board[row][col] = 0;
            if (!competeMoveStatus.win) {
                return new MoveStatus(false, row, col);
            }
        }
        return new MoveStatus(false, -1, -1);
    }

    public static void main(String[] args) {
        Solution s = new Solution(5);
        s.board = new int[][] {
                {1,1,1,1,1},
                {1,1,0,-1,1},
                {1,0,1,1,-1},
                {-1,1,0,1,1},
                {1,1,0,1,1},
        };
        System.out.println(s.valid());
        s.board = new int[][] {
                {1,1,0,1,1},
                {-1,1,1,1,1},
                {1,0,0,1,-1},
                {1,1,0,1,1},
                {1,1,0,1,1},
        };
        System.out.println(s.valid());
        s.board = new int[][] {
                {1,1,0,1,-1},
                {1,1,1,-1,1},
                {1,0,-1,1,1},
                {1,-1,0,1,1},
                {-1,1,0,1,1},
        };
        System.out.println(s.valid());
        s.board = new int[][] {
                {1,1,0,1,1},
                {1,1,1,-1,1},
                {1,0,-1,1,1},
                {1,-1,0,1,1},
                {-1,1,0,1,-1},
        };
        System.out.println(s.valid());
    }
}
