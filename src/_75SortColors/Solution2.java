package _75SortColors;

public class Solution2 {
    // 000...0 (i->最后一个0) 111...1(cur) 2(j)...222
    public void sortColors(int[] nums) {
        int i = -1, cur = 0, j = nums.length;
        while (cur < j) {
            if (nums[cur] == 0) {
                i++;
                swap(nums, i, cur);
                if (i == cur) {
                    cur++;
                }
            } else if (nums[cur] == 2) {
                j--;
                swap(nums, cur, j);
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
