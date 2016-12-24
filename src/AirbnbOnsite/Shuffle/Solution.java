package AirbnbOnsite.Shuffle;

public class Solution {
    public void shuffle(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int right = medianSort(arr);
        int left = 0;
        for (int i = right; i < arr.length; i++) {
            if (i % 2 == 1) {
                swap(arr, i, left);
                left += 2;
                if (left >= right) {
                    return;
                }
            }
        }
    }

    private int medianSort(int[] arr) {
        int target = arr.length/2;
        findKth(arr, target, 0, arr.length-1);
        return target;
    }

    private void findKth(int[] arr, int target, int i, int j) {
        if (i >= j) {
            return;
        }
        if (target == 0) {
            return;
        }
        int pivot = arr[j];
        int left = i-1;
        int right = i;
        for (; right < j; right++) {
            if (arr[right] < pivot) {
                left++;
                swap(arr, right, left);
            }
        }
        swap(arr, j, left+1);
        if (target == right) {
            return;
        }
        if (target < right) {
            findKth(arr, target, i, left);
        } else {
            findKth(arr, target - (right+1), right+1, j);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, -3, 4, -1, -2, 2, 4, -1, 9, 5};
        new Solution().shuffle(arr);
        for (int n : arr) {
            System.out.println(n);
        }
    }
}
