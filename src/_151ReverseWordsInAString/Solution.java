package _151ReverseWordsInAString;

public class Solution {
    public String reverseWords(String s) {
        String trim = s.trim();
        if (trim.isEmpty()) {
            return trim;
        }
        char[] str = reverse(trim.toCharArray(), 0, trim.length()-1);
        int start = 0, end = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                str[end] = str[i];
                end++;
            } else if (i > 0 && str[i-1] != ' ') {
                reverse(str, start, end-1);
                str[end++] = ' ';
                start = end;
            }
        }
        reverse(str, start, end-1);
        return new String(str, 0, end);
    }

    public char[] reverse(char[] arr, int i, int j) {
        while (i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return arr;
    }
}
