package _4MedianOfTwoSortedArrays;

public class Solution {
    /*
        A:   [k/2-1个数, aMid, ...]
        B:   [k/2-1个数, bMid, ...]
        if (aMid > bMid)
            bMid不可能成为kth element. 因为比它小的数有 (k/2-1) + (k/2-1) = k - 2个
            舍去A的前一半(k/2个元素， 包括aMid)， A从aMid+1开始继续往下， k变成k - k/2
        else
        ...
    */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int s1 = nums1.length;
        int s2 = nums2.length;
        int mid = findKth(nums1, 0, nums2, 0, (s1 + s2 + 1)/2);
        int mid_1 = findKth(nums1, 0, nums2, 0, (s1 + s2 + 2)/2);
        return (double)(mid + mid_1)/2;
    }

    public static int findKth(int A[], int aStart, int B[], int bStart, int k) {
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];
        }
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return A[aStart] > B[bStart] ? B[bStart] : A[aStart];
        }

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) {
            aMid = A[aStart + k/2 - 1];
        }
        if (bStart + k/2 - 1 < B.length) {
            bMid = B[bStart + k/2 - 1];
        }

        if (aMid > bMid) {
            return findKth(A, aStart, B, bStart + k/2, k - k/2);
        } else {
            return findKth(A, aStart + k/2, B, bStart, k - k/2);
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3};
        int[] B = new int[] {3, 3};
        System.out.println(findMedianSortedArrays(A, B));
    }
}
