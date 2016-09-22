package _307RangeSumQueryMutable;

class NumArray {
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int low;   // left value of the range
        int high;  // right value of the range
        int sum;    // sum of current range

        public SegmentTreeNode(SegmentTreeNode left, SegmentTreeNode right, int low, int high, int sum) {
            this.left = left;
            this.right = right;
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }

    SegmentTreeNode root;

    private SegmentTreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return new SegmentTreeNode(null, null, low, high, nums[low]);
        }
        int mid = low + (high - low)/2;
        SegmentTreeNode left = buildTree(nums, low, mid);
        SegmentTreeNode right = buildTree(nums, mid+1, high);
        SegmentTreeNode cur = new SegmentTreeNode(left, right, low, high, left.sum + right.sum);
        return cur;
    }

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    private void updateSegmentTree(SegmentTreeNode cur, int i, int val) {
        if (cur == null || cur.low > i || cur.high < i) {
            return;
        }
        if (cur.low == cur.high) {
            if (cur.low == i) {
                cur.sum = val;
            }
        } else {
            int mid = cur.low + (cur.high - cur.low)/2;
            if (i <= mid) {
                updateSegmentTree(cur.left, i, val);
            } else {
                updateSegmentTree(cur.right, i, val);
            }
            cur.sum = cur.left.sum + cur.right.sum;
        }
    }

    void update(int i, int val) {
        updateSegmentTree(root, i, val);
    }

    private int sumRange(SegmentTreeNode cur, int i, int j) {
        if (cur == null) {
            return 0;
        }
        if (cur.low == i && cur.high == j) {
            return cur.sum;
        }
        int mid = cur.low + (cur.high - cur.low)/2;
        if (mid >= j) {
            return sumRange(cur.left, i, j);
        } else if (mid < i){
            return sumRange(cur.right, i, j);
        }
        return sumRange(cur.left, i, mid) + sumRange(cur.right, mid+1, j);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
}

public class Solution {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1,3,5});
        System.out.println(numArray.sumRange(0, 1));
        numArray.update(1, 10);
        System.out.println(numArray.sumRange(1, 2));
    }
}
