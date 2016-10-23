package Snapchat.DiagonallyPrint;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> print(int[][] arr) {
        List<List<Integer>> res = new LinkedList<>();
        for (int j = 0; j < arr[0].length; j++) {
            res.add(printHelper(arr, 0, j));
        }
        for (int i = 1; i < arr.length; i++) {
            res.add(printHelper(arr, i, arr[0].length-1));
        }
        return res;
    }

    private List<Integer> printHelper(int[][] arr, int i, int j) {
        List<Integer> buffer = new LinkedList<>();
        while (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length) {
            buffer.add(arr[i][j]);
            i++;
            j--;
        }
        return buffer;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] ipt = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(test.print(ipt));
    }
}
