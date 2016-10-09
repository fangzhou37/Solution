package _86PartitionList;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1), other = new ListNode(-1);
        ListNode cur1 = smaller, cur2 = other;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = other.next;
        cur2.next = null;
        return smaller.next;
    }
}
