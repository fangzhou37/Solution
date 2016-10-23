package _314BinaryTreeVerticalOrderTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class Solution {
    class Pair {
        TreeNode node;
        int score;

        public Pair(TreeNode node, int score) {
            this.node = node;
            this.score = score;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (!treeMap.containsKey(cur.score)) {
                treeMap.put(cur.score, new LinkedList<Integer>());
            }
            treeMap.get(cur.score).add(cur.node.val);

            if (cur.node.left != null) {
                queue.offer(new Pair(cur.node.left, cur.score-1));
            }
            if (cur.node.right != null) {
                queue.offer(new Pair(cur.node.right, cur.score+1));
            }
        }
        // Treemap.keySet() would return NavigableKeySet (sorted key ket)
        // Treemap.values would return values in ascending order
        //  for (Integer score : treeMap.keySet()) {
        //      res.add(treeMap.get(score));
        //  }
        res.addAll(treeMap.values());
        return res;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(5);
        head.left.right.left = new TreeNode(4);
        head.left.right.right = new TreeNode(8);
        head.left.right.right.right = new TreeNode(10);
        head.right.left = new TreeNode(6);
        head.right.left.left = new TreeNode(11);
        head.right.right = new TreeNode(9);

        System.out.println(new Solution().verticalOrder(head));
    }
}
