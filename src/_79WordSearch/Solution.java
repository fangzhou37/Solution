package _79WordSearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] res = new boolean[1];
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, word, 0, res, visited);
                if (res[0]) {
                    return true;
                }
            }
        }
        return res[0];
    }

    private void dfs(char[][] board, int i, int j, String word, int index, boolean[] res, boolean[][] visited) {
        if (res[0]) {
            return;
        }
        if (index >= word.length()) {
            res[0] = true;
            return;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (board[i][j] != word.charAt(index)) {
            return;
        }
        visited[i][j] = true;
        dfs(board, i+1, j, word, index+1, res, visited);
        dfs(board, i-1, j, word, index+1, res, visited);
        dfs(board, i, j+1, word, index+1, res, visited);
        dfs(board, i, j-1, word, index+1, res, visited);
        visited[i][j] = false;
    }
}
