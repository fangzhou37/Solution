package _230KthSmallestElementInABST;

class Answer {
    boolean hasAnswer;
    int val;
}

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //Answer ans = new Answer();
        //dfs(root, k, ans);
        int[] kk = new int[] {k};
        int[] ans = new int[1];
        find(root, kk, ans);
        return ans[0];
    }

    private int dfs(TreeNode root, int k, Answer ans) {
        if (root == null) {
            return 0;
        }
        int leftCount = dfs(root.left, k, ans);
        if (leftCount + 1 == k) {
            ans.hasAnswer = true;
            ans.val = root.val;
        }
        int rightCount = dfs(root.right, k - leftCount - 1, ans);
        return leftCount + rightCount + 1;
    }

    private void find(TreeNode cur, int[] k, int[] ans) {
        if (cur == null) {
            return;
        }
        find(cur.left, k, ans);
        k[0]--;
        if (k[0] == 0) {
            ans[0] = cur.val;
        }
        find(cur.right, k, ans);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(2);
        new Solution().kthSmallest(head, 1);
    }
}
