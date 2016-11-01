package _15_3Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (start != i + 1 && nums[start - 1] == nums[start]) {
                    start++;
                    continue;
                }
                if (end != nums.length - 1 && nums[end + 1] == nums[end]) {
                    end--;
                    continue;
                }

                if (nums[start] + nums[end] == sum) {
                    List<Integer> solution = new LinkedList<>();
                    solution.add(nums[i]);
                    solution.add(nums[start]);
                    solution.add(nums[end]);
                    res.add(solution);
                    start++;
                    end--;
                } else if (nums[start] + nums[end] > sum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }
}
