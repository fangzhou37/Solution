package _92ReverseLinkedListII;

public class Solution2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode holder = new ListNode(-1);
        ListNode firstPre = holder, first = head, second = head;
        holder.next = head;
        for (int i = 1; i < n; i++) {
            if (i < m) {
                firstPre = first;
                first = first.next;
            }
            second = second.next;
        }
        // [firstPre first ... second secondNext] -> [firstPre second ... first secondNext]
        ListNode secondNext = second.next;
        reverse(first, second);
        first.next = secondNext;
        firstPre.next = second;
        return holder.next;
    }

    private void reverse(ListNode i, ListNode j) {
        j.next = null;
        ListNode pre = null;
        while (i != null) {
            ListNode next = i.next;
            i.next = pre;
            pre = i;
            i = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Solution2().reverseBetween(head, 2, 4);
    }
}
