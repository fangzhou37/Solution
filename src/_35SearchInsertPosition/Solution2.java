package _35SearchInsertPosition;

public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        int pos = -1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                pos = mid;  // 比target大的都是潜在候选
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        // 如果所有元素都比target小,插在nums.length
        return pos == -1 ? nums.length : pos;
    }
}
