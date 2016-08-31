package _177PopulatingNextRightPointersInEachNodeII;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode pre = null;    // pre node of current level
            TreeLinkNode nextLevelStart = null;   // start of next level
            for (; cur != null; cur = cur.next) {
                if (nextLevelStart == null) {
                    nextLevelStart = cur.left != null ? cur.left : cur.right;
                }
                if (cur.left != null) {
                    if (pre != null) { pre.next = cur.left; }
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) { pre.next = cur.right; }
                    pre = cur.right;
                }
            }
            cur = nextLevelStart;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode head = new TreeLinkNode(1);
        head.left = new TreeLinkNode(2);
        head.right = new TreeLinkNode(3);
        head.left.left = new TreeLinkNode(4);
        head.left.right = new TreeLinkNode(5);
        new Solution().connect(head);
        System.out.println();
    }

}
