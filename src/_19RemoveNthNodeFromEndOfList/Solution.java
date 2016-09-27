package _19RemoveNthNodeFromEndOfList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode holder = new ListNode(-1);
        holder.next = head;
        ListNode slow = head, fast = head, pre = holder;
        n--;    // n would become the difference between last element(fast) of the window and the first element(slow)
        while (fast != null && n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        ListNode slowNext = slow.next;
        pre.next = slow.next;
        return holder.next;
    }
}
