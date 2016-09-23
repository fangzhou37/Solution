package _229MajorityElementII;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int count1 = 0, count2 = 0, cand1 = 0, cand2 = 1;
        for (int n : nums) {
            if (n == cand1) {
                count1++;
            } else if (n == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }

        }
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == cand1) {
                count1++;
            } else if (n == cand2) {
                count2++;
            }
        }
        if (count1 > nums.length/3) {
            res.add(cand1);
        }
        if (count2 > nums.length/3){
            res.add(cand2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{1,2,3}));
    }
}
