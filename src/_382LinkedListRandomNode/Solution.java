package _382LinkedListRandomNode;


import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    private final ListNode head;
    private final Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode pick = null;
        ListNode cur = head;
        for (int i = 1; cur != null; i++) {
            if (random.nextInt(i) == 0) {
                pick = cur;
            }
            cur = cur.next;
        }
        return pick.val;
    }
}
