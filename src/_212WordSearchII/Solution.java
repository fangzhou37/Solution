package _212WordSearchII;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> validWords = new HashSet<>();
        boolean[] res = new boolean[1];
        boolean[][] visited = new boolean[board.length][board[0].length];
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "", 0, res, visited, validWords, trie);
            }
        }
        return new LinkedList<>(validWords);
    }

    private void dfs(
            char[][] board,
            int i,
            int j,
            String cur,
            int index,
            boolean[] res,
            boolean[][] visited,
            Set<String> validWords,
            Trie trie) {
        if (res[0]) {
            return;
        }
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
        dfs(board, i+1, j, cur, index+1, res, visited, validWords, trie);
        dfs(board, i-1, j, cur, index+1, res, visited, validWords, trie);
        dfs(board, i, j+1, cur, index+1, res, visited, validWords, trie);
        dfs(board, i, j-1, cur, index+1, res, visited, validWords, trie);
        visited[i][j] = false;
    }

    class TrieNode {
        Character c;
        TrieNode[] children;
        boolean isLeaf;
        // Initialize your data structure here.
        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }

        public void insert(String s, int i) {
            if (i < s.length()) {
                char cur = s.charAt(i);
                if (children[cur - 'a'] == null) {
                    children[cur - 'a'] = new TrieNode();
                    children[cur - 'a'].c = cur;
                }
                children[cur - 'a'].insert(s, i+1);
            }
            if (i == s.length()) {
                isLeaf = true;
            }
        }

        public boolean search(String s, int i) {
            if (i < s.length()) {
                char cur = s.charAt(i);
                if (children[cur - 'a'] == null || children[cur - 'a'].c != cur) {
                    return false;
                }
                return children[cur - 'a'].search(s, i+1);
            }
            return isLeaf;
        }

        public boolean startWith(String s, int i) {
            if (i < s.length()) {
                char cur = s.charAt(i);
                if (children[cur - 'a'] == null || children[cur - 'a'].c != cur) {
                    return false;
                }
                return children[cur - 'a'].startWith(s, i+1);
            }
            return true;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            root.insert(word, 0);
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word.isEmpty()) {
                return root.isLeaf;
            }
            char first = word.charAt(0);
            if (root.children[first - 'a'] == null) {
                return false;
            }
            return root.children[first - 'a'].search(word, 1);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix.isEmpty()) {
                return true;
            }
            char first = prefix.charAt(0);
            if (root.children[first - 'a'] == null) {
                return false;
            }
            return root.children[first - 'a'].startWith(prefix, 1);
        }
    }
}