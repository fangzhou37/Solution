package Snapchat2.PatternTransform;

public class Solution {
    public boolean isValid(String[] s1, String[] s2, int[] pattern) {
        StringBuffer bufferForS1 = new StringBuffer();
        StringBuffer bufferForS2 = new StringBuffer();
        for (int nextIndex : pattern) {
            if (nextIndex >= s1.length || nextIndex >= s2.length) {
                return false;
            }
            bufferForS1.append(s1[nextIndex]);
            bufferForS2.append(s2[nextIndex]);
        }
        return bufferForS1.toString().equals(bufferForS2.toString());
    }

    public int[] findPattern(String[] s1, String[] s2) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid(
                new String[] {"abc", "a", "ccc"},
                new String[] {"bc", "aa", "d"},
                new int[] {1, 0}
        ));
    }
}
