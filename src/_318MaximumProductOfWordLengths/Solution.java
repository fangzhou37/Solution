package _318MaximumProductOfWordLengths;

public class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] cs = words[i].toCharArray();
            for (int j = 0; j < cs.length; j++) {
                mask[i] |= (1 << cs[j] - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
