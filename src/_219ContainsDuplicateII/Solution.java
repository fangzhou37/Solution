package _219ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n) && i - map.get(n) <= k) {
                return true;
            }
            map.put(n, i);
        }
        return false;
    }
}
