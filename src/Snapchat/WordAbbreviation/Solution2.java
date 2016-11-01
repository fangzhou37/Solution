package Snapchat.WordAbbreviation;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count;
    }

    public String[] abbrev(String[] words) {
        String[] res = new String[words.length];
        Map<String, TrieNode> map = new HashMap<>();
        for (String word : words) {
            String abbWord = "" + word.charAt(0) + word.length() + word.charAt(word.length()-1);
            if (!map.containsKey(abbWord)) {
                map.put(abbWord, new TrieNode());
            }
            // Trie : abbWord -> List<Original string that abbreviated to the same abbWord>
            addToTrie(word, map.get(abbWord));
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String abbWord = "" + word.charAt(0) + word.length() + word.charAt(word.length()-1);
            String prefix = findPrefix(word, map.get(abbWord));
            String newAbbWord = prefix + word.length() + word.charAt(word.length()-1);
            res[i] = newAbbWord.length() < word.length() ? newAbbWord : word;
        }
        return res;
    }

    private void addToTrie(String word, TrieNode trieNode) {
        TrieNode root = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.children[c-'a'] == null) {
                root.children[c-'a'] = new TrieNode();
            }
            root = root.children[c-'a'];
            root.count++;
        }
    }

    private String findPrefix(String s, TrieNode trieNode) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            trieNode = trieNode.children[c-'a'];
            sb.append(c);
            if (trieNode != null && trieNode.count == 1) {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
