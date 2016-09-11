package _228SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int end = i;
            while (end + 1 < nums.length && nums[end+1] == nums[end] + 1) {
                end++;
            }
            if (end == i) {
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[end]));
            }
            i = end;
        }
        return res;
    }
}
