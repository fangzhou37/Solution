package _18_4Sum;

import java.util.*;

public class Solution3 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, List<int[]>> map = new HashMap<>(nums.length);
        for (int i = nums.length-1; i >= 0; i--) {
            if (i != nums.length-1 && nums[i] == nums[i+1]) {   // 尽量选大的，因为后面要求pair[0] > i/j; pair[1] > i/j
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (j != i-1 && nums[j] == nums[j+1]) {
                    continue;
                }
                if (!map.containsKey(nums[i] + nums[j])) {
                    map.put(nums[i] + nums[j], new LinkedList<int[]>());
                }
                map.get(nums[i] + nums[j]).add(new int[]{i, j});
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = target - nums[i] - nums[j];
                if (map.containsKey(sum)) {
                    for (int[] pair : map.get(sum)) {
                        if (pair[0] <= i || pair[1] <= i || pair[0] <= j || pair[1] <= j) {
                            continue;
                        }
                        res.add(Arrays.asList(nums[i],nums[j],nums[pair[0]],nums[pair[1]]));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution3().fourSum(new int[] {1,2,3,4,5,6,7}, 16));
        System.out.println(new Solution3().fourSum(new int[] {-3,-2,-1,0,0,1,2,3}, 0));
        //[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        //[[-3,-2,2,3],[-3,-1,1,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2]]
    }
}