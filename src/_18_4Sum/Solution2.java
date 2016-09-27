package _18_4Sum;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // Cache possible sums of two elements
        Set<Integer> twoSum = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                twoSum.add(nums[i]+nums[j]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {   // 去重
                continue;
            }
            int first = nums[i];
            for (int s = i + 1; s < nums.length; s++) {
                if (s != i + 1 && nums[s] == nums[s-1]) {
                    continue;
                }
                int second = nums[s];
                if (!twoSum.contains(target - first - second)) {
                    continue;
                }

                int j = s + 1, k = nums.length-1;
                while (j < k) {
                    if (j != s + 1 && nums[j] == nums[j-1]) {   // 去重
                        j++;
                        continue;   // 易忘记
                    }
                    if (k != nums.length-1 && nums[k] == nums[k+1]) {   // 去重
                        k--;
                        continue;   // 易忘记
                    }
                    if (nums[j] + nums[k] == target-first-second) {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(nums[i]);
                        tuple.add(nums[s]);
                        tuple.add(nums[j]);
                        tuple.add(nums[k]);
                        res.add(tuple);
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] > target-first-second) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().fourSum(new int[]{-2,-1,0,0,1,2}, 0));
    }
}
