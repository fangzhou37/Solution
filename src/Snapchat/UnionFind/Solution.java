package Snapchat.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public class UF {
        int[] U;

        public UF(int size) {
            U = new int[size];
            for (int i = 0; i < size; i++) {
                U[i] = i;
            }
        }

        public int find(int node) {
            while (U[node] != node) {
                node = U[node];
            }
            return node;
        }

        public void union(int node1, int node2) {
            int p1 = find(node1);
            int p2 = find(node2);
            if (p1 == p2) {
                return;
            }
            U[p1] = p2;
        }
    }

    public int makeGroupAndCount(int[][] m) {
        UF uf = new UF(m.length);

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        Set<Integer> groups = new HashSet<>();
        for (int i = 0; i < m.length; i++) {
            groups.add(uf.find(i));
        }
        return groups.size();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
        };
        System.out.println(new Solution().makeGroupAndCount(matrix));
    }
}
