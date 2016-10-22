package Snapchat.FindPath;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
    //test case input:
    [
        [0,0,0,s,0,0],
        [0,0,0,0,0,0],
        [0,0,0,0,0,0],
        [0,0,0,0,0,0],
        [0,0,0,0,0,e],
        [0,0,0,0,0,0],
    ]
    * */
    private int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    // 一个矩阵里某些位置有墙，给一个出发点及目的地，求最短距离
    public int findpath1(int[][] matrix, int[] start, int[] end){
        if (matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        if (start[0] == end[0] && start[1] == end[1]) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (matrix[cur[0]][cur[1]] != 0) {  // has been visited
                continue;
            }
            matrix[cur[0]][cur[1]] = -1;    // mark as visited
            for (int[] dir : directions) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                    continue;
                }
                if (x == end[0] && y == end[1]) {
                    return cur[2] + 1;
                }
                if (matrix[x][y] == 0) {
                    queue.offer(new int[] {x, y, cur[2] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };
        System.out.println(new Solution().findpath1(matrix, new int[] {0,3}, new int[] {4,5}));
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col);
                System.out.print(",\t");
            }
            System.out.println();
        }
    }
}
