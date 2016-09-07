package _76MinimumWindowSubstring;

public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        int[] m = new int[256];
        int[] dict = new int[256];
        int count = 0;  // count of distinct characters
        for (char c : t.toCharArray()) {
            if (m[(int)c] == 0) {
                count++;
            }
            m[(int)c]++;
            dict[(int)c]++;
        }
        String res = s;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dict[(int)s.charAt(i)] != 0) {  // 前移
                m[(int) s.charAt(i)]--;
                if (m[(int) s.charAt(i)] == 0) {
                    count--;
                }

                if (count == 0) {
                    // It is a valid window
                    for (int j = start; j < i; j++) {   // 后进
                        if (dict[(int)s.charAt(j)] == 0) {  // 不在dict，直接pass，别忘了start++
                            start++;
                            continue;
                        }
                        if (m[(int) s.charAt(j)] < 0) {
                            start++;
                            m[(int) s.charAt(j)]++; // 别忘了改m中的状态
                        } else {
                            break;
                        }
                    }

                    if (i - start + 1 < res.length()) {
                        res = s.substring(start, i + 1);
                    }
                }
            }
        }
        if (count != 0) {   // 别忘了找不到window的情况
            return "";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
