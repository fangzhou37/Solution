package _303RangeSumQueryImmutable;

class NumArray {
    int[] sum;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] += nums[i];
            if (i != 0) {
                sum[i] += sum[i-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];
    }
}

public class Solution {

}
