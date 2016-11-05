package Snapchat.FindPathForMaze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    /*
    从左上角走到右下角
    "0"代表通路，"5"代表墙。. 矩阵长得是这样
    [
        [1, 5, 5, 5, 5, 0],
        [0, 5, 0, 5, 5, 0],
        [0, 5, 0, 0, 0, 0],
        [0, 5, 0, 0, 5, 0],
        [0, 0, 0, 5, 0, 9]
    ]
    */

    private int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    // BFS
    public boolean havePath(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (matrix[cur[0]][cur[1]] == -1) {  // has been visited
                continue;
            }
            matrix[cur[0]][cur[1]] = -1;    // mark as visited
            for (int[] dir : directions) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                    continue;
                }
                if (x == matrix.length - 1 && y == matrix[0].length - 1) {
                    return true;
                }
                if (matrix[x][y] == 0) {
                    queue.offer(new int[] {x, y});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 5, 5, 5, 5, 0},
                {0, 5, 0, 5, 5, 0},
                {0, 5, 0, 0, 0, 0},
                {0, 5, 0, 0, 5, 0},
                {0, 0, 0, 5, 0, 0},
        };
        System.out.println("----------------------------");
        System.out.println(new Solution3().havePath(matrix));
        System.out.println("Print Matrix:");
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col);
                System.out.print(",\t");
            }
            System.out.println();
        }
    }
}
