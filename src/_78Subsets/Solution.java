package _78Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new LinkedList<Integer>()); // empty set
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(res.get(i));
                newList.add(n);
                res.add(newList);
            }
        }
        return res;
    }
}
