package _4MedianOfTwoSortedArrays;

public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        return ((double)findKth(nums1, 0, nums2, 0, (l1 + l2 + 1)/2) + (double)findKth(nums1, 0, nums2, 0, (l1 + l2 + 2)/2))/2;
    }

    private int findKth(int[] nums1, int i1, int[] nums2, int i2, int k) {
        if (i1 >= nums1.length) {
            return nums2[i2 + k - 1];
        }
        if (i2 >= nums2.length) {
            return nums1[i1 + k - 1];
        }
        if (k == 1) {
            return nums1[i1] > nums2[i2] ? nums2[i2] : nums1[i1];
        }
        int pivot1 = i1 + k/2 - 1 < nums1.length ? nums1[i1 + k/2 - 1] : Integer.MAX_VALUE;
        int pivot2 = i2 + k/2 - 1 < nums2.length ? nums2[i2 + k/2 - 1] : Integer.MAX_VALUE;
        if (pivot1 > pivot2) {
            return findKth(nums1, i1, nums2, i2 + k/2, k - k/2);
        } else {
            return findKth(nums1, i1 + k/2, nums2, i2, k - k/2);
        }
    }
}
