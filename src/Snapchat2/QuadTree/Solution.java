package Snapchat2.QuadTree;

public class Solution {
    static class Node {
        Node NW;
        Node NE;
        Node SE;
        Node SW;
        int value;
    }

    public Node buildQuadTree(int[][] board) {
        return buildQuadTree(board, 0, 0, board.length, board[0].length);
    }

    // Assume width and height of board is 2 ^ n
    private Node buildQuadTree(int[][] board, int sx, int sy, int ex, int ey) {
        Node cur = new Node();
        if (sx == ex-1 && sy == ey-1) {
            cur.value = board[sx][sy];
            return cur;
        }
        // If it's rectangle, we could add two 'if's here,
        // if (sx == ex-1) ...
        // if (sy == ey-1) ...
        if (sx > ex-1 || sy > ey-1) {
            return cur;
        }

        int midx = sx + (ex - sx) / 2;
        int midy = sy + (ey - sy) / 2;

        cur.NW = buildQuadTree(board, sx, sy, midx, midy);
        cur.NE = buildQuadTree(board, sx, midy, midx, ey);
        cur.SE = buildQuadTree(board, midx, midy, ex, ey);
        cur.SW = buildQuadTree(board, midx, sy, ex, midy);

        if (cur.NW.value == 0 && cur.NE.value == 0 && cur.SE.value == 0 && cur.SW.value == 0) {
            cur.value = 0;
        } else if (cur.NW.value == 1 && cur.NE.value == 1 && cur.SE.value == 1 && cur.SW.value == 1) {
            cur.value = 1;
        } else if (cur.NW.value == 2 && cur.NE.value == 2 && cur.SE.value == 2 && cur.SW.value == 2) {
            cur.value = 1;
        } else {
            cur.value = 2;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {1,0,0,1},
                {1,1,0,1},
                {1,1,0,0},
                {1,1,0,0},
                {1,1,0,0},
        };
        Node root = new Solution().buildQuadTree(board);
        System.out.println(root.value);
    }
}
