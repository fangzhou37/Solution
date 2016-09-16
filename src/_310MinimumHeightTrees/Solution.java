package _310MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 大家推崇的方法是一个类似剥洋葱的方法，就是一层一层的褪去叶节点，
    // 最后剩下的一个或两个节点就是我们要求的最小高度树的根节点
    // 类似拓扑排序，维护indegree数组和<parent, List<child> map
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> children = new HashMap<>();
        for(int i=0;i<n;i++) children.put(i, new ArrayList<Integer>());
        for (int[] pair : edges) {
            indegree[pair[0]]++;
            indegree[pair[1]]++;
            children.get(pair[0]).add(pair[1]);
            children.get(pair[1]).add(pair[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1 || indegree[i] == 0) { // is leaf, 注意为0的时候也是leaf
                leaves.add(i);
            }
        }
        int remainNodes = n;
        while (remainNodes > 2) {
            List<Integer> nextLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                indegree[leaf]--;
                remainNodes--;
                for (Integer child : children.get(leaf)) {
                    indegree[child]--;
                    if (indegree[child] == 1) {
                        nextLeaves.add(child);
                    }
                }
            }
            leaves = nextLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinHeightTrees(3, new int[][]{{0,1},{0,2}}));
    }
}
