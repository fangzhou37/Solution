package CheapestShortPath;

import java.util.*;

public class Solution {
    static class Node {
        int cost;
        int hop;
    }

    // DFS
    public int getPrice(int[][] tickets, int start, int end, int stopThreshold) {
        if (tickets.length == 0 || tickets[0].length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>>  m = new HashMap<>();   // <start, <end>>
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < tickets[0].length; j++) {
                if (tickets[i][j] == 0) {
                    continue;
                }
                if (!m.containsKey(i)) {
                    m.put(i, new ArrayList<Integer>());
                }
                m.get(i).add(j);
            }
        }

        int[] buffer = new int[tickets.length*tickets.length];
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        BackTrack(res, buffer, 0, 0, m, start, tickets, stopThreshold, end);
        return res[0];
    }

    private void BackTrack(
            int[] res,
            int[] buffer,
            int bufferInd,
            int curCost,
            Map<Integer, List<Integer>> m,
            int curCity,
            int[][] tickets,
            int stopThreshold,
            int end) {
        if (curCost > res[0]) { // 剪枝
            return;
        }
        if (curCity == end) {
            if (bufferInd + 1 >= stopThreshold) {
                res[0] = Math.min(res[0], curCost);
                return;
            }
        }
        if (bufferInd >= buffer.length || !m.containsKey(curCity)) {
            return;
        }
        buffer[bufferInd] = curCity;
        List<Integer> nextCities = m.get(curCity);
        List<Integer> nextCityCopy = new LinkedList<>(nextCities);
        for (Integer nextCity : nextCityCopy) {
            nextCities.remove(nextCity);
            BackTrack(res, buffer, bufferInd+1, curCost+tickets[curCity][nextCity],
                    m, nextCity, tickets, stopThreshold, end);
            nextCities.add(nextCity);
        }
    }

    public static void main(String[] args) {
        int[][] tickets = new int[][] {
                {0,2,1,0},
                {0,0,3,0},
                {0,0,0,4},
                {0,0,0,0}
        };
        System.out.println(new Solution().getPrice(tickets, 0, 3, 4));
    }
}
