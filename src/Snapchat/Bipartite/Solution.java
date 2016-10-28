package Snapchat.Bipartite;

import java.util.LinkedList;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph.length < 2) {
            return true;
        }
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;  // no color is assigned yet
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            int oppositeColor = 1 - color[cur];
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[cur][j] == 1) {   // edge cur -> j
                    if (color[j] != -1) {   // child has been colored
                        if (color[j] == color[cur]) {   // color conflict
                            return false;
                        }
                    } else {
                        color[j] = oppositeColor;
                        queue.offer(j);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0,1,0,1},
                {1,0,1,0},
                {0,1,0,1},
                {1,0,1,0},
        };
        System.out.println(new Solution().isBipartite(graph));
    }
}
