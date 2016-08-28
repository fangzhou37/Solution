package FindTheDifference;

public class Solution {
    // add a random character to s => t
    public char findTheDifference(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']++;
            if (i < s.length()) {
                alphabet[s.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != 0) {
                return (char) ('a' + i);
            }
        }
        return '0';
    }
}
