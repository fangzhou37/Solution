package Snapchat.FindPathForMaze;

import java.util.*;

public class Solution2 {
    private int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    static class Node {
        int x;
        int y;
        int score;

        public Node(int x, int y, int score) {
            this.x = x;
            this.y = y;
            this.score = score;
        }
    }

    // 一个矩阵里某些位置有墙，墙可以打破，每打破一个cost为1，求cost最小的路线
    public int minCost(int[][] matrix, int start_x, int start_y, int end_x, int end_y){
        PriorityQueue<Node> queue = new PriorityQueue<>(matrix.length * 2, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.score - o2.score;
            }
        });
        Node[][] nodes = new Node[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nodes[i][j] = new Node(i, j, Integer.MAX_VALUE);
            }
        }
        nodes[start_x][start_y].score = 0;
        queue.offer(nodes[start_x][start_y]);
        while (!queue.isEmpty()) {
            Node smallest = queue.poll();
            if (matrix[smallest.x][smallest.y] == -1) { // has been output
                continue;
            }
            matrix[smallest.x][smallest.y] = -1;

            for (int[] dir : directions) {
                int x = smallest.x + dir[0];
                int y = smallest.y + dir[1];
                if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                    continue;
                }
                if (matrix[smallest.x][smallest.y] != -1) {
                    continue;
                }
                if (smallest.x == end_x && smallest.y == end_y) {
                    return smallest.score;
                }
                int childScore = matrix[x][y] == 0 ? smallest.score : smallest.score + 1;
                nodes[x][y].score = Math.min(nodes[x][y].score, childScore);
                queue.offer(nodes[x][y]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] maze = new int[][]{
                {1,1,1,8,0,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,1,0,1},
                {1,1,1,1,1,8},
                {1,1,1,1,1,1}};
        System.out.println(solution2.minCost(maze,0,3,4,5));
    }
}
