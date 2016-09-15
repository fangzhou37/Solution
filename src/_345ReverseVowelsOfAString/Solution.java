package _345ReverseVowelsOfAString;

public class Solution {
    public String reverseVowels(String s) {
        String Vowels = "AEIOUaeiou";
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        while (i < j) {
            if (Vowels.indexOf(arr[i]) == -1) {
                i++;
                continue;
            }
            if (Vowels.indexOf(arr[j]) == -1) {
                j--;
                continue;
            }
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return new String(arr);
    }
}
