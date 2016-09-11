package _208ImplementTrie;

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

public class Solution {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ac");
        trie.insert("bcd");
        System.out.println(trie.search("a"));
        System.out.println(trie.search("ac"));
        System.out.println(trie.startsWith("bca"));
        System.out.println(trie.startsWith("ab"));
    }
}
