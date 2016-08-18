package _127WordLadder;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int length = 2;
        Set<String> head = new HashSet<>();
        Set<String> tail = new HashSet<>();
        head.add(beginWord);
        tail.add(endWord);
        Set<String> visited = new HashSet<>();
        while (!head.isEmpty()) {
            if (head.size() > tail.size()) {
                Set<String> t = head;
                head = tail;
                tail = t;
            }

            Set<String> next = new HashSet<>();
            for (String parent : head) {
                char[] chs = parent.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String child = String.valueOf(chs);
                        if (tail.contains(child)) {
                            return length;
                        }
                        if (wordList.contains(child) && !visited.contains(child)) {
                            next.add(child);
                            visited.add(child);
                        }
                        chs[i] = old;
                    }
                }
            }
            head = next;
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("ho");
        dict.add("ao");
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("a");
        dict.add("c");
        System.out.println(new Solution().ladderLength("hit", "cog", dict));
    }
}