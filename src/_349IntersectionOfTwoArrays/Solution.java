package _349IntersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> n1 = new HashSet<>();
        for (int number : nums1) {
            n1.add(number);
        }
        for (int number : nums2) {
            if (n1.contains(number)) {
                res.add(number);
            }
        }
        int[] r = new int[res.size()];
        int i = 0;
        for (Integer number : res) {
            r[i++] = number;
        }
        return r;
    }
}
