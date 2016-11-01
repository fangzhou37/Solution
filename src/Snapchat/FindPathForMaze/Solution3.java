package Snapchat.FindPathForMaze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    /*
    "1"代表起点，位于左上角；"9"代表重点，位于右下角；"0"代表通路，"5"代表墙。. 矩阵长得是这样
    [
        [1, 5, 5, 5, 5, 0],
        [0, 5, 0, 5, 5, 0],
        [0, 5, 0, 0, 0, 0],
        [0, 5, 0, 0, 5, 0],
        [0, 0, 0, 5, 0, 9]
    ]
    */

    private int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    // DFS
    public boolean havePath(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int[] start = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1]});
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
                if (matrix[x][y] == 9) {
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
                {1, 5, 5, 5, 5, 0},
                {0, 5, 0, 5, 5, 0},
                {0, 5, 0, 0, 0, 0},
                {0, 5, 0, 0, 5, 0},
                {0, 0, 0, 5, 0, 9},
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
