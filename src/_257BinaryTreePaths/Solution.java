package _257BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        dfs(root, sb, res);
        return res;
    }

    private void dfs(TreeNode n, StringBuffer sb, List<String> res) {
        if (n == null) {
            return;
        }
        int endIndex = sb.length();
        if (sb.length() != 0) {
            sb.append("->");
        }
        sb.append(n.val);
        if (n.left == null && n.right == null) {
            res.add(sb.toString());
            sb.delete(endIndex, sb.length());
            return;
        }
        dfs(n.left, sb, res);
        dfs(n.right, sb, res);
        sb.delete(endIndex, sb.length());
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        System.out.println(new Solution().binaryTreePaths(head));
    }
}
