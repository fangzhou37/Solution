package _77Combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        int[] buf = new int[n];
        for (int i = 1; i <= n; i++) {
            buf[i-1] = i;
        }
        backTracking(buf, 0, res, k);
        return res;
    }

    private void backTracking(int[] buf, int cur, List<List<Integer>> res, int k) {
        if (cur == k) {
            List<Integer> sol = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                sol.add(buf[i]);
            }
            res.add(sol);
            return;
        }
        int previousElement = cur == 0 ? -1 : buf[cur-1];
        for (int i = cur; i < buf.length; i++) {
            if (buf[i] < previousElement) { // 去重复,保证序列递增
                continue;
            }
            swap(buf, i, cur);
            backTracking(buf, cur+1, res, k);
            swap(buf, i, cur);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
