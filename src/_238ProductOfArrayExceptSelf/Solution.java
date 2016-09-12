package _238ProductOfArrayExceptSelf;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] front = new int[nums.length];
        int[] back = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                front[i] = 1;
                back[nums.length-1-i] = 1;
            } else {
                front[i] = front[i-1] * nums[i-1];
                back[nums.length-1-i] = back[nums.length-i] * nums[nums.length-i];
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = front[i] * back[i];
        }
        return res;
    }
}
