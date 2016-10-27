package Snapchat.FindCycle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public class Node {
        int val;
        List<Node> next;
        public Node(int val){
            this.val = val;
            next = new ArrayList<>();
        }
    }

    public List<Node> generateGraph(){
        List<Node> graph = new ArrayList<>();
        Node g1 = new Node(1);
        graph.add(g1);
        Node g2 = new Node(2);
        graph.add(g2);
        Node g3 = new Node(3);
        graph.add(g3);
        Node g4 = new Node(4);
        graph.add(g4);
        Node g5 = new Node(5);
        graph.add(g5);
        Node g6 = new Node(6);
        graph.add(g6);
        g1.next.add(g2);
        g4.next.add(g1);
        g5.next.add(g6);
        g5.next.add(g1);
        g6.next.add(g4);
        //g1.next.add(g6);  // cycle
        return graph;
    }

    // 有向图有环 == 从每个root开始的dfs有back edge
    public boolean hasCycle(List<Node> graph) {
        if (graph.isEmpty()) {
            return false;
        }
        Set<Node> inStack = new HashSet<>(graph.size());
        Set<Node> zeroDegreeNodes = new HashSet<>(graph);
        for (Node n : graph) {
            for (Node child : n.next) {
                zeroDegreeNodes.remove(child);
            }
        }
        if (zeroDegreeNodes.isEmpty()) {    // 易错
            return true;
        }
        for (Node root : zeroDegreeNodes) {
            if (dfs(root, inStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Node root, Set<Node> inStack) {
        if (inStack.contains(root)) {
            return true;
        }
        inStack.add(root);
        for (Node child : root.next) {
            if (dfs(child, inStack)) {
                return true;
            }
        }
        inStack.remove(root);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(solution.generateGraph()));
    }
}
