package _350IntersectionOfTwoArraysII;

import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> n1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (n1.containsKey(nums1[i])) {
                n1.put(nums1[i], n1.get(nums1[i])+1);
            } else {
                n1.put(nums1[i], 1);
            }
        }
        for (int number : nums2) {
            if (n1.containsKey(number)) {
                res.add(number);
                int count = n1.get(number);
                if (count == 1) {
                    n1.remove(number);
                } else {
                    n1.put(number, count - 1);
                }
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
