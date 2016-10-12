package _106ConstructBinaryTreeFromInorderAndPostorderTraversal;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode build(int[] inorder, int i, int j, int[] postorder, int i2, int j2) {
        if (i > j) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[j2]);
        int inorderInd = -1;
        for (int k = i; k <= j; k++) {
            if (inorder[k] == postorder[j2]) {
                inorderInd = k;
                break;
            }
        }
        int leftCount = inorderInd - i;
        int rightCount = j - inorderInd;
        cur.left = build(inorder, i, i+leftCount-1, postorder, i2, i2+leftCount-1);
        cur.right = build(inorder, inorderInd+1, j, postorder, i2+leftCount, j2-1);
        return cur;
    }
}
