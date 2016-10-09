package _95UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start == end) {         // 易忘
            res.add(new TreeNode(start));
        } else if (start > end) {   // 易忘
            res.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = generate(start, i - 1);
                List<TreeNode> right = generate(i + 1, end);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode cur = new TreeNode(i);
                        cur.left = l;
                        cur.right = r;
                        res.add(cur);
                    }
                }
            }
        }
        return res;
    }
}
