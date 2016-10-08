package _79WordSearch;

public class Solution2 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return word.isEmpty();
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] wc = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, wc, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] wc, int w, boolean[][] visited) {
        if (w == wc.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (wc[w] != board[i][j]) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        boolean res =
                dfs(board, i + 1, j, wc, w + 1, visited) ||
                dfs(board, i - 1, j, wc, w + 1, visited) ||
                dfs(board, i, j + 1, wc, w + 1, visited) ||
                dfs(board, i, j - 1, wc, w + 1, visited);
        visited[i][j] = false;
        return res;
    }
}
