package _61RotateList;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode cur = head, pre = null, start = head;
        int total = 0;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            total++;
        }
        k %= total;

        pre.next = head;    //首尾相连
        cur = head;
        for (int i = 0; i < total - k; i++) {   //走total-k步断开即可
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        return cur;
    }
}
