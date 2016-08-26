package _25ReverseNodesInKGroup;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = null, cur = head, tail = head;
        // Find range [cur, tail]
        for (int i = 0; i < k-1; i++) {
            tail = tail == null ? null : tail.next;
        }
        if (tail == null) {
            return head;
        }

        // reverse range [cur, tail]
        ListNode next = null;
        for (int i = 0; i < k-1; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        next = cur.next;
        cur.next = pre;

        // continue recursively for next range
        head.next = reverseKGroup(next, k);
        return cur;
    }
}
