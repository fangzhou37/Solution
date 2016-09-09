package _220ContainsDuplicateIII;

import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        final TreeSet<Integer> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Integer smaller = values.ceiling(n-t);
            Integer larger = values.floor(n+t);
            if ((smaller != null && smaller <= n) || (larger != null && larger >= n)) {
                return true;
            }
            values.add(n);
            if (i >= k) {
                values.remove(nums[i-k]);
            }
        }
        return false;
    }
}
