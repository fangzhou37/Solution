package _203RemoveLinkedListElements;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode holder = new ListNode(-1), cur = head, pre = holder;
        holder.next = head;
        while (cur != null) {
            if (cur.val != val) {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;
        return holder.next;
    }
}
