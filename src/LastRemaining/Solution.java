package LastRemaining;

import java.util.Stack;

public class Solution {
    // 1..n    左右轮流跳着取数,直到最后一个
    // 1 2 3 4 5(left to right) -> 2 4(right to left) -> 2
    // 这是一棵树
    // 从root下来只需要知道该往左还是右即可
    // 有一个stack来存左右选择
    public int lastRemaining(int n) {
        if (n < 3) {
            return n;
        }

        // 求树高
        int h = 1, nodes = 1;
        while (nodes < n) {
            h++;
            nodes = nodes << 1;
        }
        h--;

        // 求path
        Stack<Boolean> s = new Stack<>();
        boolean left = true;
        for (int remain = n; remain > 1; remain /= 2) {
            if (remain % 2 != 0) {
                s.push(false);
            } else {
                s.push(!left);
            }
            left = left ? false : true;
        }

        // 走path
        int res = 0;
        while (!s.isEmpty()) {
            res *= 2;
            if (!s.pop()) {
                res++;
            }
            left = left ? false : true;
        }
        return res+1;
    }
}
