package _138CopyListWithRandomPointer;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class Solution {
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode holder = new RandomListNode(-1), cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            if (holder.next == null) {
                holder.next = cur.next;
            }
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode curCopy = cur.next, randNext = cur.random, randNextCopy = (randNext == null ? null : randNext.next);
            curCopy.random = randNextCopy;
            // cur.next = curCopy.next; // don't do this, since this would break following random pointer processing
            cur = curCopy.next;
            // curCopy.next = cur == null ? null : cur.next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode curCopy = cur.next;
            cur.next = curCopy.next;
            cur = curCopy.next;
            if (cur == null) {
                curCopy.next = null;
            } else {
                curCopy.next = cur.next;
            }
        }
        return holder.next;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        head.random = three;
        three.random = two;
        two.random = three;
        head.next = two;
        two.next = three;
        RandomListNode copy = copyRandomList(head);
        System.out.println(copy);
    }
}