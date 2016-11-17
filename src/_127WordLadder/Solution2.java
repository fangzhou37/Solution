package _127WordLadder;

import java.util.*;

public class Solution2 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add(beginWord);
        int length = 1;
        while (!current.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String cur : current) {
                if (visited.contains(cur)) {
                    continue;
                }
                visited.add(cur);

                char[] cs = cur.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char old = cs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cs[i] = c;
                        String child = new String(cs);
                        if (child.equals(endWord)) {
                            return length + 1;
                        }
                        if (!cur.equals(child) && !visited.contains(child) && wordList.contains(child)) {
                            next.add(child);
                        }
                    }
                    cs[i] = old;
                }
            }
            length++;
            current = next;
        }
        return 0;
    }

    public List<String> ladderpath(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return new LinkedList<>(Arrays.asList(beginWord));
        }
        Set<String> visited = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add(beginWord);
        List<String> path = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();   // <child, parent>
        while (!current.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String cur : current) {
                if (visited.contains(cur)) {
                    continue;
                }
                visited.add(cur);

                char[] cs = cur.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char old = cs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cs[i] = c;
                        String child = new String(cs);
                        if (child.equals(endWord)) {
                            parent.put(child, cur);
                            return genPath(parent, endWord, beginWord);
                        }
                        if (!cur.equals(child) && !visited.contains(child) && wordList.contains(child)) {
                            parent.put(child, cur);
                            next.add(child);
                        }
                    }
                    cs[i] = old;
                }
            }
            current = next;
        }
        return null;
    }

    private List<String> genPath(Map<String, String> parent, String endWord, String beginWord) {
        LinkedList<String> path = new LinkedList<>();
        String cur = endWord;
        while (cur != null) {
            path.addFirst(cur);
            cur = parent.containsKey(cur) ? parent.get(cur) : null;
        }
        return path;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));

        System.out.println(new Solution().ladderLength("hot", "dog", dict));
        System.out.println(new Solution2().ladderLength("hot", "dog", dict));
        System.out.println(new Solution2().ladderpath("hot", "dog", dict));
    }
}
