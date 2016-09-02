package _23MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode holder = new ListNode(-1), cur = holder;
        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        for (ListNode n : lists) {
            if (n != null) {
                queue.add(n);
            }
        }

        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            ListNode next = n.next;
            cur.next = n;
            n.next = null;
            cur = cur.next;
            if (next != null) {
                queue.add(next);
            }
        }

        return holder.next;
    }
}
