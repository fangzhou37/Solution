package _90SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        int prevStart = 1;
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            if (i == 0 || nums[i] != nums[i-1]) {
                prevStart = 0;
            }
            for (int j = prevStart; j < size; j++) {
                List<Integer> cur = new ArrayList<>(res.get(j));
                cur.add(nums[i]);
                res.add(cur);
            }
            prevStart = size;
        }
        return res;
    }
}
