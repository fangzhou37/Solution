package _135Candy;

public class Solution {
    // 左右各扫一遍，计算每个点最大可能的增长 (左右方向的最大值)
    public int candy(int[] ratings) {
        int[] incr = new int[ratings.length];   // increments
        int increment = 1;   // current increment
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                incr[i] = Math.max(increment++, incr[i]);
            } else {
                increment = 1;
            }
        }

        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                incr[i] = Math.max(increment++, incr[i]);
            } else {
                increment = 1;
            }
        }

        int res = ratings.length;
        for (int ic : incr) {
            res += ic;
        }
        return res;
    }
}
