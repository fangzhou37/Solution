package _398RandomPickIndex;

import java.util.Random;

public class Solution {
    int[] nums;
    Random r;

    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }

    //E.g. int[] nums = new int[] {1,2,3,3,3};
    //When we met the first 3, poolSize -> 1, r.nextInt(1) would be 0
    //When we met the second 3, poolSize -> 2, survival rate = 1/2
    //When we met the third 3, poolSize -> 3, survival rate = 1/3

    //The possibility for the first 3 : 1/2 * 2/3 = 1/3
    //The possibility for the second 3 : 1/2 * 2/3 = 1/3
    //The possibility for the third 3 : 1/3

    public int pick(int target) {
        int pick = -1;
        int poolSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                poolSize++;
                if (r.nextInt(poolSize) == 0) {
                    pick = i;
                }
            }
        }
        return pick;
    }
}
