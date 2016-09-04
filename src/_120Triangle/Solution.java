package _120Triangle;

import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Collections.reverse(triangle);
        if (triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return 0;
        }
        // 2
        // 1 3
        Integer[] arr = new Integer[triangle.get(0).size()+1];  // 0 0 0
        Arrays.fill(arr, 0);
        Iterator<List<Integer>> iter = triangle.iterator();
        while (iter.hasNext()) {
            List<Integer> cur = iter.next();    // 1 3
            for (int j = 0; j < cur.size(); j++) {
                arr[j] = Math.min(arr[j], arr[j+1]) + cur.get(j);   // 1 3 0
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(new Integer[]{2}));
        input.add(Arrays.asList(new Integer[]{2, 3}));
        System.out.println(new Solution().minimumTotal(input));
    }

}
