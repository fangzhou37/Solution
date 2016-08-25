package _92ReverseLinkedListII;

public class Solution {
    // * -> ... -> *premm -> *mm -> ...-> *n -> n.next
    // * -> ... -> *premm -> *tail <- ... *pre  *mm -> n.next
    // * -> ... -> *premm -> *tail <- ... *pre <- *mm  n.next
    // * -> ... -> *premm -> *mm -> ... -> *tail -> n.next
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode holder = new ListNode(-1), mm = holder, premm = null;
        holder.next = head;
        int i = 0;
        // Find premm and mm (of position m)
        for (; i != m; i++) {
            premm = mm;
            mm = mm.next;
        }

        ListNode pre = null, next;
        for (; i != n; i++) {
            next = mm.next;
            mm.next = pre;
            pre = mm;
            mm = next;
        }

        next = mm.next; // n.next
        mm.next = pre;
        ListNode tail = premm.next;
        premm.next = mm;
        tail.next = next;
        return holder.next;
    }
}
