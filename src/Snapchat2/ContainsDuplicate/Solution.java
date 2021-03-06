package Snapchat2.ContainsDuplicate;

import java.util.*;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            // 0,1,2,3   k = 2
            if (i > k) {
                set.remove(nums[i-k-1]);
            }
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

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

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            // 0,1,2,3   k = 2
            if (i > k) {
                set.remove((long) nums[i - k - 1]);
            }

            if (t < Integer.MAX_VALUE/2) {
                for (int j = 0; j <= t; j++) {
                    if (set.contains((long) n + j) || set.contains((long) n - j)) {
                        return true;
                    }
                }
            } else {
                for (Long existed : set) {
                    if (Math.abs(existed - n) <= t) {
                        return true;
                    }
                }
            }
            set.add((long) n);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[] {-1,-1}, 1,0));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[] {1,2}, 0,1));
    }
}
