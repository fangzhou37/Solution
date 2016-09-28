package _24SwapNodesInPairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode holder = new ListNode(-1), cur = holder;
        while (head != null && head.next != null) {
            ListNode nextNext = head.next.next;
            cur.next = head.next;
            cur = cur.next;
            cur.next = head;
            cur = cur.next;
            cur.next = null;
            head = nextNext;
        }
        if (head != null) {
            cur.next = head;
        }
        return holder.next;
    }
}
