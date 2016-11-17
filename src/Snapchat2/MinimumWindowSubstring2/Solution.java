package Snapchat2.MinimumWindowSubstring2;

import java.util.*;

public class Solution {
    public String findWindow(List<String> words, String paragraph) {
        Set<String> dict = new HashSet<>(words);
        Map<String, Integer> freq = new HashMap<>(words.size());
        for (String word : words) {
            if (!freq.containsKey(word)) {
                freq.put(word, 0);
            }
            freq.put(word, freq.get(word)+1);
        }

        //String[] para = paragraph.split("\\W+");
        int start = 0;
        int needed = words.size();
        String res = paragraph + " ";
        for (int i = 0; i < paragraph.length(); i++) {
            if (Character.isAlphabetic(paragraph.charAt(i))) {
                int j = i+1;
                // 1. find word
                while (Character.isAlphabetic(paragraph.charAt(j))) {
                    j++;
                }
                String word = paragraph.substring(i, j);
                if (dict.contains(word)) {
                    if (freq.get(word) > 0){
                        needed--;
                        freq.put(word, freq.get(word)-1);
                    }

                    // 2. find a valid window
                    if (needed == 0) {
                        // forward start and ready to make it invalid


                        if (res.length() > j - start) {
                            res = paragraph.substring(start, j);
                        }

                        // forward start and make it invalid
                        for (int k = start; k < j; k++) {
                            if (Character.isAlphabetic(paragraph.charAt(k))) {
                                j++;
                            }
                        }
                    }
                }
                i = j;
            }
        }
        return res.length() > paragraph.length() ? null : res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findWindow(Arrays.asList(""), "hi there! I'm Joe. Nice to meet you :)"));
    }
}
