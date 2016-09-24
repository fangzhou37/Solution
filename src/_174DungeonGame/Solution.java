package _174DungeonGame;

public class Solution {
    public int calculateMinimumHP(int[][] d) {
        if (d.length == 0 || d[0].length == 0) {
            return 0;
        }
        int[][] life = new int[d.length][d[0].length];
        for (int i = d.length-1; i >= 0; i--) {
            for (int j = d[0].length-1; j >= 0; j--) {
                int down = i != d.length-1 ? life[i+1][j] : Integer.MAX_VALUE;
                int right = j != d[0].length-1 ? life[i][j+1] : Integer.MAX_VALUE;
                int min = Math.min(down, right);    // 在下面或右边选出最小代价
                if (min == Integer.MAX_VALUE) {     // 右下角最后一个元素
                    min = 1;
                }
                life[i][j] = Math.max(min - d[i][j], 1);
            }
        }
        return life[0][0];
    }
}
