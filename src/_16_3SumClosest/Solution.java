package _16_3SumClosest;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int first;
        int sum = Integer.MAX_VALUE;
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1, k = nums.length-1; j < k;) {
                int g = target - (nums[i] + nums[j] + nums[k]);
                if (Math.abs(g) < gap) {
                    sum = nums[i] + nums[j] + nums[k];
                    gap = Math.abs(g);
                }
                if (g == 0) {
                    return sum;
                } else if (g < 0) {
                    k--;
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else {
                    j++;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
            }
        }
        return sum;
    }
}
