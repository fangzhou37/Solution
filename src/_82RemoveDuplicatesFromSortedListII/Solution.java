package _82RemoveDuplicatesFromSortedListII;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head, pre = null, holder = new ListNode(-1), holderCur = holder;
        while (cur != null) {
            if ((pre == null || cur.val != pre.val) && (cur.next == null || cur.next.val != cur.val )) {
                holderCur.next = cur;
                holderCur = holderCur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        holderCur.next = null;
        return holder.next;
    }
}
