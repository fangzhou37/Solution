package _77Combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*
    * 一开始, n >= k
    * 每次,要么n 和 k一起减小,要么n减小
    * 前者最后肯定k会到0, 后者肯定会达到n = k, 这两个就是边界
    * */
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            List<List<Integer>> res = new LinkedList<>();
            res.add(new LinkedList<Integer>());
            return res;
        }
        if (k == n) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            List<List<Integer>> res = new LinkedList<>();
            res.add(row);
            return res;
        }
        List<List<Integer>> sub = combine(n-1, k-1);
        for (List<Integer> s : sub) {
            s.add(n);
        }
        sub.addAll(combine(n-1, k));
        return sub;
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> row = new LinkedList<>();
        dfs(res, row, n, k, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> row, int n, int k, int start) {
        if (row.size() == k) {
            res.add(new LinkedList<Integer>(row));
            return;
        }
        if (start > n) {
            return;
        }
        row.addLast(start);
        dfs(res, row, n, k, start+1);   // choose the element
        row.removeLast();
        dfs(res, row, n, k, start+1);   // not choose it
    }

    public static void main(String[] args) {
        new Solution().combine(4, 2);
    }
}
