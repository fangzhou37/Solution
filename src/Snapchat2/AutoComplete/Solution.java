package Snapchat2.AutoComplete;

import java.util.*;

public class Solution {
    /*
/a/dea
/abc/dea
/abc/def
/abc/dehg/acc
/abc/dehg/acg
    * */

    public String minInput(List<String> fileSystem, String path) {
        for (String file : fileSystem) {
            add(file);
        }
        return search(path);
    }

    static class TrieNode {
        int count  = 0; // the number of children
        Map<Character, TrieNode> children = new HashMap<>(255);
    }

    TrieNode root = new TrieNode();

    private void add(String path) {
        TrieNode cur = root;
        for (char c : path.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.count++;
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
    }

    private String search(String path) {
        StringBuffer sb = new StringBuffer(path.length());
        TrieNode cur = root;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (cur.count > 1) {
                sb.append(c);
            }
            cur = cur.children.get(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> files = Arrays.asList(
                "/a/dea",
                "/abc/dea",
                "/abc/def",
                "/abc/dehg/acc",
                "/abc/dehg/acw"
        );

        System.out.println(new Solution().minInput(files, "/abc/dehg/acw"));
    }
}
