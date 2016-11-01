package Snapchat.ConstructBinaryTreeFromPreorderAndInorderTraversal;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) throws Exception {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            throw new Exception("Invalid input");
        }
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1, 0);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart) throws Exception {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preStart]);
        int curIndexInInorder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[preStart] == inorder[i]) {
                curIndexInInorder = i;
                break;
            }
        }
        if (curIndexInInorder == -1 || curIndexInInorder < inStart) {
            throw new Exception("Invalid input");
        }
        int leftSubTreeSize = curIndexInInorder - inStart;
        cur.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + leftSubTreeSize, inStart);
        cur.right = buildTreeHelper(preorder, inorder, preStart + leftSubTreeSize + 1, preEnd, curIndexInInorder+1);
        return cur;
    }

    public static void main(String[] args) throws Exception {
        int[] preorder = new int[] {1,2,4,5,3,6,7};
        int[] inorder = new int[] {4,2,5,1,6,3,7};
        TreeNode n = new Solution().buildTree(preorder, inorder);
        System.out.println();
    }
}
