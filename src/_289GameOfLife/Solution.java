package _289GameOfLife;

public class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighb = 0;
                if (isLive(board, i-1, j)) {liveNeighb++;}
                if (isLive(board, i+1, j)) {liveNeighb++;}
                if (isLive(board, i, j-1)) {liveNeighb++;}
                if (isLive(board, i, j+1)) {liveNeighb++;}
                if (isLive(board, i-1, j-1)) {liveNeighb++;}
                if (isLive(board, i+1, j+1)) {liveNeighb++;}
                if (isLive(board, i-1, j+1)) {liveNeighb++;}
                if (isLive(board, i+1, j-1)) {liveNeighb++;}

                if ((board[i][j] & 1) == 0) {
                    if (liveNeighb == 3) {
                        board[i][j] |= 2;    // revive next round
                    }
                } else {
                    if (liveNeighb < 2 || liveNeighb > 3) {
                        board[i][j] &= 1;   // going to die next round
                    } else {
                        board[i][j] |= 2;   // going to live next round
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private boolean isLive(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        return (board[i][j] & 1) == 1;
    }

    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][] {{1,1},{1,0}});
    }
}
