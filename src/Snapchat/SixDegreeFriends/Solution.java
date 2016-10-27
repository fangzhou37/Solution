package Snapchat.SixDegreeFriends;

import java.util.*;

public class Solution {
    static class UndirectedGraphNode {
        List<UndirectedGraphNode> neighbors;
    }

    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        if (s == t) {
            return 0;
        }

        Map<UndirectedGraphNode, Integer> visited = new HashMap<UndirectedGraphNode, Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        queue.offer(s);
        visited.put(s, 0);
        while (!queue.isEmpty()) {
            UndirectedGraphNode frontier = queue.poll();
            int size = frontier.neighbors.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = frontier.neighbors.get(i);
                if (visited.containsKey(node)) {
                    continue;
                }
                if (node == t) {
                    return visited.get(frontier) + 1;
                }
                queue.offer(node);
                visited.put(node, visited.get(frontier) + 1);
            }
        }
        return -1;
    }
}
