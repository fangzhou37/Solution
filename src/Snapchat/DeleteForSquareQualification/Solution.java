package Snapchat.DeleteForSquareQualification;

public class Solution {
    // -2 * -2 < 5 return true
    public boolean isQualified(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return isQualify(min, max);
    }

    private boolean isQualify(int min, int max) {
        if (max < 0) {
            return false;
        }
        if (min == Integer.MIN_VALUE) {
            return false;
        }
        min = Math.abs(min);
        return (double)min < ((double)max)/min;
    }

    public int needToDeleteToQualify(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int min = arr[arr.length-1], max = arr[arr.length-1];
        int qualifiedStart = arr.length;
        if (isQualify(min, max)) {
            qualifiedStart = arr.length-1;
        }
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            if (isQualify(min, max)) {
                qualifiedStart = i;
            }
        }
        return qualifiedStart == arr.length ?
                -1 :
                qualifiedStart;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,9,2};
        System.out.println(new Solution().isQualified(arr));

        arr = new int[] {5,3,9,3};
        System.out.println(new Solution().isQualified(arr));

        System.out.println(new Solution().needToDeleteToQualify(arr));

        arr = new int[] {9,3,1,3};
        System.out.println(new Solution().needToDeleteToQualify(arr));

    }
}
