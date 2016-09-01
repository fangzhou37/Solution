package _148SortList;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开
        ListNode first = head, second = pre.next;
        pre.next = null;

        first = sortList(first);
        second = sortList(second);
        return mergeTwoLists(first, second);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode holder = new ListNode(-1), cur = holder;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
            }
            cur = cur.next;
        }
        return holder.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        new Solution().sortList(head);
    }
}
