package Snapchat2.FindCycle;

import java.util.*;

public class Solution {
    public class Node {
        int val;
        List<Node> next;
        boolean visited;

        public Node(int val){
            this.val = val;
            next = new ArrayList<>();
            visited = false;
        }
    }

    public Node generateGraph(){
        Node g1 = new Node(1);
        Node g2 = new Node(2);
        Node g3 = new Node(3);
        Node g4 = new Node(4);
        Node g5 = new Node(5);
        Node g6 = new Node(6);

        g1.next.add(g2);
        g1.next.add(g3);
        g3.next.add(g4);
        g4.next.add(g2);
        g3.next.add(g5);
        g2.next.add(g3);  // cycle
        return g1;
    }

    // 有向图有环 == 从每个root开始的dfs有back edge
    public boolean hasCycle(Node cur) {
        if (cur == null) {
            return false;
        }
        if (cur.visited) {
            return true;
        }
        cur.visited = true;
        for (Node child : cur.next) {
            if (hasCycle(child)) {
                return true;
            }
        }
        cur.visited = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(solution.generateGraph()));
    }
}
