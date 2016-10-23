package Snapchat.SubstringAnagram;

import java.util.Arrays;

public class Solution {
    public boolean hasAnagram(String s1, String s2){
        if (s2.isEmpty()) {
            return true;
        }
        int[] window = new int[128];
        for (char c : s2.toCharArray()) {
            window[c - 'a']++;
        }
        int[] dict = Arrays.copyOf(window, window.length);
        int start = 0;
        for (int end = 0; end < s1.length() && start <= s1.length() - s2.length(); end++) {
            char c = s1.charAt(end);
            window[c-'a']--;
            // dict[c - 'a'] == 0  ==>  character is not in s2, we should recover window and restart from next char (end + 1)
            // window[c-'a'] < 0  ==>  too many character c in s1, we should increment start until it looks good
            while (start <= end && (dict[c - 'a'] == 0 || window[c-'a'] < 0)) {    // invalid
                char startChar = s1.charAt(start);
                window[startChar - 'a']++;
                start++;
            }
            if (end - start + 1 == s2.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.hasAnagram("fsssdweeas","sdf"));
        System.out.println(test.hasAnagram("fsssdweeas","sdw"));
        System.out.println(test.hasAnagram("fsssdweeas","ee"));
        System.out.println(test.hasAnagram("fsssdweeas","eeas"));
        System.out.println(test.hasAnagram("fsssdweeas","fssfasdweeas"));
        System.out.println(test.hasAnagram("aeafwfeeesseedsedweeaseef","eea"));
        System.out.println(test.hasAnagram("aeafwfeeesseedsedweeaseef","eef"));
        System.out.println(test.hasAnagram("aeafwfweeesseedsedweeawseef","eew"));
        System.out.println(test.hasAnagram("aeafwfweeesseedsedweeawseew","eef"));
    }
}
