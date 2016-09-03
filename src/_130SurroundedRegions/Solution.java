package _130SurroundedRegions;

public class Solution {
    final static char zero = 'O';
    final static char cross = 'X';
    final static char temp = 'Y';

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == zero) {
                dfs(board, 0, j);  // first row
            }
            if (board[board.length-1][j] == zero) {
                dfs(board, board.length - 1, j); // last row
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == zero) {
                dfs(board, i, 0);  // first column
            }
            if (board[i][board[0].length-1] == zero) {
                dfs(board, i, board[0].length-1);  // last column
            }
        }

        markAllCharToChar(board, zero, cross);
        markAllCharToChar(board, temp, zero);
    }

    private void markAllCharToChar(char[][] board, char target, char newTarget) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target) {
                    board[i][j] = newTarget;
                }
            }
        }
    }

    //if it's 'O', dfs to mark neighbors as 'Y'
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == cross || board[i][j] == temp) {
            return;
        }
        board[i][j] = temp;
        if (i > 1 && board[i-1][j] == 'O') {
            dfs(board, i-1, j);
        }
        if (j > 1 && board[i][j-1] == 'O') {
            dfs(board, i, j-1);
        }
        if (i < board.length-1 && board[i+1][j] == 'O') {
            dfs(board, i+1, j);
        }
        if (j < board[0].length-1 && board[i][j+1] == 'O') {
            dfs(board, i, j+1);
        }
    }

    public static void main(String[] args) {
        String[] b = new String[]{
                "XXXX",
                "XXOX",
                "XXOX",
                "XOXX"
        };
        char[][] board = new char[b.length][b[0].length()];
        for (int i = 0; i < b.length; i++) {
            board[i] = b[i].toCharArray();
        }

        new Solution().solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(new String(board[i]));
        }
    }
}
