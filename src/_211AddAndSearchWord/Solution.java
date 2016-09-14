package _211AddAndSearchWord;

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    boolean isLeaf;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = root;
        return searchHelper(word, cur);
    }

    private boolean searchHelper(String word, TrieNode cur) {
        if (word.isEmpty()) {
            return cur.isLeaf;
        }
        char c = word.charAt(0);
        if (c != '.') {
            return cur.children[c-'a'] != null && searchHelper(word.substring(1), cur.children[c-'a']);
        }

        String nextString = word.substring(1);
        for (int i = 0; i < 26; i++) {
            if (cur.children[i] != null && searchHelper(nextString, cur.children[i])) {
                return true;
            }
        }
        return false;
    }
}


public class Solution {
}
