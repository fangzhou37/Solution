package _61RotateList;

public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head, pre = null;
        int total = 0;
        while (cur != null) {
            total++;
            pre = cur;
            cur = cur.next;
        }
        k %= total;

        // 首尾相连
        pre.next = head;

        ListNode cut = head;
        for (int i = 1; i < total - k; i++) {
            cut = cut.next;
        }
        ListNode next = cut.next;
        cut.next = null;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        new Solution2().rotateRight(head, 1);
    }
}
