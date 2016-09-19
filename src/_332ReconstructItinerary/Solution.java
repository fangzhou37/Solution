package _332ReconstructItinerary;

import java.util.*;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> path = new LinkedList<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK", map, path);
        return path;
    }

    private void dfs(String depart, Map<String, PriorityQueue<String>> map, LinkedList<String> path) {
        PriorityQueue<String> dests = map.get(depart);
        while (dests != null && !dests.isEmpty()) {
            // 贪心，不需担心backtrack的问题，因为肯定是一个欧拉回路，有去有回。
            dfs(dests.poll(), map, path);
        }
        path.addFirst(depart);
    }
}
