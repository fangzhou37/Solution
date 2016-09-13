package _214ShortestPalindrome;

public class Solution {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length()-1, end = s.length()-1;
        char chs[] = s.toCharArray();
        while (i < j) {
            if (chs[i] == chs[j]) {
                i++;
                j--;
            } else {
                end--;
                j = end;
                i = 0;
            }
        }
        return new StringBuffer(s.substring(end+1)).reverse().toString() + s;
    }
}
