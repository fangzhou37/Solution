package _168ExcelSheetColumnTitle;

public class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n%26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(1));
        System.out.println(new Solution().convertToTitle(26));
        System.out.println(new Solution().convertToTitle(27));
        System.out.println(new Solution().convertToTitle(28));
        System.out.println(new Solution().convertToTitle(29));
        System.out.println(new Solution().convertToTitle(51));
        System.out.println(new Solution().convertToTitle(52));
        System.out.println(new Solution().convertToTitle(53));
        System.out.println(new Solution().convertToTitle(54));
    }
}
