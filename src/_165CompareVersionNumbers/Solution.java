package _165CompareVersionNumbers;

public class Solution {
    // If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
    public int compareVersion(String version1, String version2) {
        // We want to make sure version1 is longer than version2
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int sign = 1;
        if (v1.length < v2.length) {
            String[] t = v1;
            v1 = v2;
            v2 = t;
            sign = -1;
        }
        for (int i = 0; i < v1.length; i++) {
            String sub1 = v1[i];
            if (i >= v2.length) {
                if (Integer.valueOf(sub1) == 0) {
                    continue;
                }
                return sign * 1;
            }
            String sub2 = v2[i];
            if (Integer.valueOf(sub1) > Integer.valueOf(sub2)) {
                return sign * 1;
            }
            if (Integer.valueOf(sub1) < Integer.valueOf(sub2)) {
                return sign * -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1", "0"));
    }
}
