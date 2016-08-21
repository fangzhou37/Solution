package _18_4Sum;

import java.util.*;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);

        // Cache possible sums of two elements
        Set<Integer> twoSum = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                twoSum.add(nums[i]+nums[j]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int s = i+1; s < nums.length; s++) {
                if (!twoSum.contains(target - nums[i] - nums[s])) {
                    continue;
                }
                if (s > i+1 && nums[s] == nums[s-1]) {
                    continue;
                }
                for (int j = s+1, k = nums.length-1; j < k;) {
                    if (nums[j] + nums[k] == target - nums[i] - nums[s]) {
                        res.add(Arrays.asList(nums[i], nums[s], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j-1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k+1]) {
                            k--;
                        }
                    } else if (nums[j] + nums[k] > target - nums[i] - nums[s]) {
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
        }
        return res;
    }
}
