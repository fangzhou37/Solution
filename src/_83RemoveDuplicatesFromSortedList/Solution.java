package _83RemoveDuplicatesFromSortedList;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode holder = new ListNode(-1), cur = head, tail = holder, pre = holder;
        holder.next = head;
        while (cur != null) {
            if (pre != holder && pre.val == cur.val) {
                cur = cur.next;
            } else {
                tail.next = cur;
                tail = tail.next;
                pre = cur;
                cur = cur.next;
            }
        }
        tail.next = null;
        return holder.next;
    }
}
