package Snapchat.FindTheDuplicateNumber;

public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0], fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{3,2,4,1,5,4}));
    }
}
