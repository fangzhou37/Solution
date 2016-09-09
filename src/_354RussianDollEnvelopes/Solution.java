package _354RussianDollEnvelopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    // [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3]
                    // when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] m = new int[envelopes.length];
        int length = 0;
        for (int[] env : envelopes) {
            int insert = Arrays.binarySearch(m, 0, length, env[1]); // 只需要看width即可,height已经sort
            if (insert >= 0) {
                continue;
            }
            insert = Math.abs(insert) - 1;
            m[insert] = env[1];
            if (insert == length) {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxEnvelopes(new int[][] {{3,4},{3,5},{4,5},{5,5},{5,6}}));
    }
}
