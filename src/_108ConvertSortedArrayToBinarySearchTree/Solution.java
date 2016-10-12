package _108ConvertSortedArrayToBinarySearchTree;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length-1);
    }

    private TreeNode convert(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(nums[i]);
        }
        int mid = i + (j-i)/2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = convert(nums, i, mid-1);
        cur.right = convert(nums, mid+1, j);
        return cur;
    }
}
