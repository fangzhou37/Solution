package _109ConvertSortedListToBinarySearchTree;

public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode curNode = head;
        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        ListNode[] cur = new ListNode[1];
        cur[0] = head;
        return convert(cur, 0, count-1);
    }

    private TreeNode convert(ListNode[] cur, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            TreeNode thisNode = new TreeNode(cur[0].val);
            cur[0] = cur[0].next;
            return thisNode;
        }
        int mid = i + (j-i)/2;
        TreeNode left = convert(cur, i, mid-1);
        TreeNode thisNode = new TreeNode(cur[0].val);
        cur[0] = cur[0].next;
        TreeNode right = convert(cur, mid+1, j);
        thisNode.left = left;
        thisNode.right = right;
        return thisNode;
    }
}
