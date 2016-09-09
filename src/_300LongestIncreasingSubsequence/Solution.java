package _300LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> m = new ArrayList<>();
        for (int n : nums) {
            int insert = Collections.binarySearch(m, n);
            if (insert >= 0) {  // existed
                continue;
            } else {
                insert = Math.abs(insert) - 1;  // 'ceil'
            }
            if (insert > m.size()-1) {
                m.add(n);
            }
            m.set(insert, n);
        }
        return m.size();
    }

    public static void main(String[] args) {
        List<Integer> m = new ArrayList<>();
        m.add(1);
        m.add(3);
        m.add(4);
        m.add(5);
        m.add(6);
        System.out.println(Collections.binarySearch(m, 0));
        System.out.println(Collections.binarySearch(m, 1));
        System.out.println(Collections.binarySearch(m, 2));
        System.out.println(Collections.binarySearch(m, 6));
        System.out.println(Collections.binarySearch(m, 7));
        System.out.println(Collections.binarySearch(m, 8));
        System.out.println(new Solution().lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
