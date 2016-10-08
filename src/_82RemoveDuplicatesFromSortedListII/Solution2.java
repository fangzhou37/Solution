package _82RemoveDuplicatesFromSortedListII;

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode holder = new ListNode(-1), cur = head, tail = holder;
        holder.next = head;
        while (cur != null) {
            if (cur.next == null || cur.val != cur.next.val) {
                tail.next = cur;
                tail = tail.next;
                cur = cur.next;
            } else {
                int value = cur.val;
                while (cur!= null && cur.val == value) {
                    cur = cur.next;
                }
            }
        }
        tail.next = null;
        return holder.next;
    }
}
