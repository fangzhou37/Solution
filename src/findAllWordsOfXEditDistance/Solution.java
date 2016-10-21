package findAllWordsOfXEditDistance;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> find(String[] dict, String target, int x) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        Set<String> res = new HashSet<>();
        findQualifiedWords(trie.root, "", target, 0, x, res);
        return new LinkedList<>(res);
    }

    public static void findQualifiedWords(TrieNode cur, String path, String target, int i, int x, Set<String> res) {
        if (i == target.length()) {
            if (cur.isLeaf && x == 0) {
                res.add(path);
            }
        }

        if (i < target.length()) {
            char c = target.charAt(i);
            if (cur.children[c - 'a'] != null) {
                findQualifiedWords(cur.children[c - 'a'], path + c, target, i + 1, x, res);
            }
        }

        if (x > 0) {
            findQualifiedWords(cur, path, target, i + 1, x - 1, res);   // delete c
            for (int j = 0; j < 26; j++) {
                if (cur.children[j] != null) {
                    findQualifiedWords(cur.children[j], path + (char) ('a' + j), target, i, x - 1, res);       // add
                    findQualifiedWords(cur.children[j], path + (char) ('a' + j), target, i + 1, x - 1, res);   // replace c
                }
            }
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // Assume all lower case
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isLeaf = true;
        }
    }

    public static void main(String[] args) {
        String[] dict = new String[] {"aa", "ac", "aw", "wb", "bb", "abc", "cab", "acb", "acbb", "wa", "bw", "ba", "c"};
        System.out.println(new Solution().find(dict, "ab", 1));
        System.out.println("[cab, abc, ac, wb, aa, bb, aw, acb]");

        dict = new String[] {"aa", "ac", "aw", "wb", "bb", "abc", "cab", "acb", "acbb", "wa", "bw", "ba", "c", "b"};
        System.out.println(new Solution().find(dict, "b", 2));
        System.out.println("[abc, b, ba, c, bw, aw, acb, cab, ac, wb, aa, wa, bb]");
    }
}
