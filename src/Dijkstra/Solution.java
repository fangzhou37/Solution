package Dijkstra;

import java.util.*;

public class Solution {
    static class Node {
        Integer id;
        Integer score;
        Integer prev;

        public Node(Integer id, Integer score) {
            this.id = id;
            this.score = score;
        }
    }

    public List<Integer> findPath(int[][] relations) {
        Node[] nodes = new Node[relations.length];
        for (int i = 0; i < relations.length; i++) {
            nodes[i] = new Node(i, Integer.MAX_VALUE);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(relations.length, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.score - o2.score;
            }
        });

        nodes[0].score = 0;
        queue.add(nodes[0]);
        Set<Node> visited = new HashSet<>(relations.length);
        while (!queue.isEmpty()) {
            Node curSmallest = queue.poll();
            visited.add(curSmallest);

            int[] children = relations[curSmallest.id];
            for (int child : children) {
                if (visited.contains(nodes[child])) {
                    continue;
                }
                int newScore = curSmallest.score +
                        (curSmallest.id - nodes[child].id) * (curSmallest.id - nodes[child].id);
                if (newScore < nodes[child].score) {
                    nodes[child].prev = curSmallest.id;
                    nodes[child].score = newScore;
                }
                if (!queue.contains(nodes[child])) {
                    queue.offer(nodes[child]);
                }
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        int cur = relations.length-1;
        if (nodes[cur].score == Integer.MAX_VALUE) {
            return path;
        }
        path.addFirst(cur);
        while (cur != 0) {
            path.addFirst(nodes[cur].prev);
            cur = nodes[cur].prev;
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] relations = new int[][] {{1,2,3},{2,3,5},{1,3,4},{0,1,6},{2,6},{1,6},{3,4,5}};
        System.out.println(new Solution().findPath(relations));
    }
}
