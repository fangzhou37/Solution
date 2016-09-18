package _378KthSmallestElementInASortedMatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

class Tuple {
    int row;
    int col;

    public Tuple(int r, int c) {
        row = r;
        col = c;
    }
}

public class Solution {
    public int kthSmallest(final int[][] matrix, int k) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>(k, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return matrix[o1.row][o1.col] - matrix[o2.row][o2.col];
            }
        });

        for (int row = 0; row < matrix.length; row++) {
            queue.add(new Tuple(row, 0));
        }
        for (int i = 0; i < k-1; i++) {
            Tuple cur = queue.poll();
            if (cur.col == matrix[0].length-1) {
                continue;
            }
            queue.add(new Tuple(cur.row, cur.col + 1));
        }
        Tuple kth = queue.poll();
        return matrix[kth.row][kth.col];
    }
}
