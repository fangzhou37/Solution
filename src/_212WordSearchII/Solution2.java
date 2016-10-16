package _212WordSearchII;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> validWords = new HashSet<>();
        StringBuffer buf = new StringBuffer();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "", validWords, trie, visited);
            }
        }
        return new LinkedList<>(validWords);
    }

    private void dfs(char[][] board, int i, int j, String cur, Set<String> validWords, Trie trie, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        cur += board[i][j];
        if (!trie.startsWith(cur)) {
            return;
        }
        if (trie.search(cur)) {
            validWords.add(cur);
        }
        visited[i][j] = true;
        dfs(board, i+1, j, cur, validWords, trie, visited);
        dfs(board, i-1, j, cur, validWords, trie, visited);
        dfs(board, i, j+1, cur, validWords, trie, visited);
        dfs(board, i, j-1, cur, validWords, trie, visited);
        visited[i][j] = false;
    }

    class Trie {
        class TrieNode {
            boolean isLeaf;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode curNode = root;
            for (char c : word.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    curNode.children[c - 'a'] = new TrieNode();
                }
                curNode = curNode.children[c - 'a'];
            }
            curNode.isLeaf = true;
        }

        public boolean search(String cur) {
            TrieNode curNode = root;
            for (char c : cur.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    return false;
                }
                curNode = curNode.children[c - 'a'];
            }
            return curNode.isLeaf;
        }

        public boolean startsWith(String cur) {
            TrieNode curNode = root;
            for (char c : cur.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    return false;
                }
                curNode = curNode.children[c - 'a'];
            }
            return true;
        }
    }
}