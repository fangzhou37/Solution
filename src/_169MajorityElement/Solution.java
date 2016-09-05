package _169MajorityElement;

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int count = 0;
        int major = 0;
        for (int n : nums) {
            if (count == 0) {
                major = n;
                count++;
            } else if (major == n) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
