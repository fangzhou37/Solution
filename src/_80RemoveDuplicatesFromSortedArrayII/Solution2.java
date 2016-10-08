package _80RemoveDuplicatesFromSortedArrayII;

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int cur = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[cur] && nums[i] == nums[cur-1]) {
                continue;
            }
            nums[++cur] = nums[i];
        }
        return cur + 1;
    }
}
