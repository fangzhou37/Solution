package _15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {   // 去重
                continue;
            }
            int first = nums[i];
            int j = i + 1, k = nums.length-1;
            while (j < k) {
                if (j != i + 1 && nums[j] == nums[j-1]) {   // 去重
                    j++;
                    continue;   // 易忘记
                }
                if (k != nums.length-1 && nums[k] == nums[k+1]) {   // 去重
                    k--;
                    continue;   // 易忘记
                }
                if (nums[j] + nums[k] == -first) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[j]);
                    tuple.add(nums[k]);
                    res.add(tuple);
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > -first) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
