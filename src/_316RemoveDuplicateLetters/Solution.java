package _316RemoveDuplicateLetters;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int[] cnt = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            cnt[c-'a']++;
        }
        int discardCandidate = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] < cs[discardCandidate]) {
                // find i which is smaller than discardCandidate. Should discard discardCandidate
                // e.g. bbacb, discardCandidate = 0, but in 2, 'a' is smaller than 'b', discard first two 'b'
                discardCandidate = i;
            }
            cnt[cs[i]-'a']--;
            if (cnt[cs[i]-'a'] == 0) {  // find unique character, should make discard decision before the char
                break;
            }
        }
        return cs[discardCandidate] + removeDuplicateLetters(s.substring(discardCandidate+1).replaceAll(""+cs[discardCandidate], ""));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bbacwadb"));
    }
}
