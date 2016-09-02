package _90SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int size = res.size();
            start = (i > 0 && nums[i] == nums[i-1]) ? start : 0;
            for (int j = start; j < size; j++) {
                List<Integer> l = res.get(j);
                List<Integer> l1 = new ArrayList<>(l);
                l1.add(n);
                res.add(l1);
            }
            start = size;
        }
        return res;
    }
}
