package _113PathSumII;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new LinkedList<>();
        }
        if (root.left == null && root.right == null) {
            List<List<Integer>> solutionSet = new LinkedList<>();
            if (root.val == sum) {
                LinkedList<Integer> oneSolution = new LinkedList<>();
                oneSolution.addFirst(root.val);
                solutionSet.add(oneSolution);
            }
            return solutionSet;
        }
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        for (List<Integer> oneSolution : left) {
            ((LinkedList<Integer>) oneSolution).addFirst(root.val);
        }
        for (List<Integer> oneSolution : right) {
            ((LinkedList<Integer>) oneSolution).addFirst(root.val);
        }
        left.addAll(right);
        return left;
    }
}
