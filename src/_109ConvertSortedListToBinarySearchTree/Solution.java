package _109ConvertSortedListToBinarySearchTree;

public class Solution {
    ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        cur = head;
        ListNode n = head;
        int k = 0;
        while (n != null) {
            k++;
            n = n.next;
        }
        return convert(0, k-1);
    }

    public TreeNode convert(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode left = convert(start, mid-1);
        TreeNode currentTreeNode = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = convert(mid+1, end);
        currentTreeNode.left = left;
        currentTreeNode.right = right;
        return currentTreeNode;
    }
}
