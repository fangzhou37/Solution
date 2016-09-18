package _213HouseRobberII;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] startFromFirstHouse = new int[nums.length + 1];
        int[] startFromSecondHouse = new int[nums.length + 1];
        startFromFirstHouse[1] = nums[0];
        startFromSecondHouse[2] = nums[1];
        int max = Math.max(nums[0], nums[1]);   // 容易漏掉前两个屋
        for (int i = 3; i <= nums.length; i++) {
            if (i != nums.length) {
                startFromFirstHouse[i] = Math.max(startFromFirstHouse[i - 2], startFromFirstHouse[i - 3]) + nums[i - 1];
                max = Math.max(max, startFromFirstHouse[i]);
            }
            startFromSecondHouse[i] = Math.max(startFromSecondHouse[i - 2], startFromSecondHouse[i - 3]) + nums[i - 1];
            max = Math.max(max, startFromSecondHouse[i]);   // 与其在最后判断那个是最大,不如每层都判断,保证不遗漏
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[] {1,3,1}));
    }
}
