package _45JumpGameII;

public class Solution2 {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int level = 0, levelRange = 0, nextRange = 0, i = 0;
        while (i <= nextRange && i < nums.length) {
            if (i > levelRange) {   // 先递增,后判断是否已经可达最后一个元素
                levelRange = nextRange;
                level++;
            }
            if (i + nums[i] >= nums.length - 1) {
                return level+1;
            }
            nextRange = Math.max(nextRange, i + nums[i]);
            i++;
        }
        return -1;
    }
}
