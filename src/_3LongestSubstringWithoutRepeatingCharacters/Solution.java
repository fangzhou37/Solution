package _3LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];
        int count = 0, start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            m[s.charAt(i)]++;
            count++;
            while (m[s.charAt(i)] > 1) {
                m[s.charAt(start)]--;
                start++;
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
