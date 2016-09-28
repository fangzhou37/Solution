package _21MergeTwoSortedLists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode holder = new ListNode(-1), cur = holder;
        while (l1 != null) {
            if (l2 == null || (l2 != null && l1.val <= l2.val)) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else if (l2 != null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        cur.next = null;
        if (l2 != null) {
            cur.next = l2;
        }
        return holder.next;
    }
}
