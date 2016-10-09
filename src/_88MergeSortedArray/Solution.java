package _88MergeSortedArray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, cur = m + n - 1;
        while (cur >= 0) {
            int n1 = tail1 >= 0 ? nums1[tail1] : Integer.MIN_VALUE;
            int n2 = tail2 >= 0 ? nums2[tail2] : Integer.MIN_VALUE;
            if (n1 < n2) {
                nums1[cur] = n2;
                tail2--;
            } else {
                nums1[cur] = n1;
                tail1--;
            }
            cur--;
        }
    }
}
