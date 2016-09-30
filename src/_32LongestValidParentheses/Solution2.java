package _32LongestValidParentheses;

public class Solution2 {
    public int longestValidParentheses(String s) {
        return Math.max(getLongest(s), getLongest(reverse(s)));
    }

    private String reverse(String s) {  // 这和单纯的reverse不同,不但顺序reverse,'('和')'也对换了
        StringBuffer sb = new StringBuffer();
        for (char c : new StringBuffer(s).reverse().toString().toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    private int getLongest(String s) {
        int count = 0;
        char[] cs = s.toCharArray();
        int start = 0;
        int max = 0;
        for (int i = 0; i < cs.length; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                max = Math.max(max, i - start + 1);
            } else if (count < 0) {
                count = 0;
                start = i+1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestValidParentheses("(()("));
    }
}
