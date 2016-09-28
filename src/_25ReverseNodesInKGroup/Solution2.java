package _25ReverseNodesInKGroup;

public class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < k-1; i++) {
            cur = cur.next;
            if (cur == null) {
                return head;
            }
        }
        ListNode nextGroup = cur.next;
        cur.next = null;
        ListNode pre = null;
        cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(nextGroup, k);
        return pre;
    }
}
