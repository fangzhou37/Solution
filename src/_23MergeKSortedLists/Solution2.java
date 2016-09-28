package _23MergeKSortedLists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode holder = new ListNode(-1), cur = holder;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
                cur.next = null;
            }
        }
        return holder.next;
    }
}
