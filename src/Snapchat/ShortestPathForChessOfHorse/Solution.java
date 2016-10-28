package Snapchat.ShortestPathForChessOfHorse;

import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    static class Position {
        int x;
        int y;
        Position pre;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private int[][] directions = new int[][]{{-2,1},{2,1},{2,-1},{-2,-1},{1,-2},{1,2},{-1,2},{-1,-2}};

    // Assume we only need to print out 1 of the valid solutions
    public List<Position> getShortest(int[][] board, Position start, Position end) {
        List<Position> res = new LinkedList<>();
        res.add(start);
        if (start.equals(end)) {
            return res;
        }

        LinkedList<Position> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            LinkedList<Position> next = new LinkedList<>();
            for (Position cur : queue) {
                if (board[cur.y][cur.x] != 0) { // skip if we have visited
                    continue;
                }
                if (cur.equals(end)) {
                    return genPositionPath(start, cur);
                }
                board[cur.y][cur.x] = 1;    // mark as visited
                for (int[] dir : directions) {
                    int x = cur.x + dir[0];
                    int y = cur.y + dir[1];
                    if (x >= 0 && x < board[0].length && y >= 0 && y < board.length) {
                        Position child = new Position(x,y);
                        child.pre = cur;
                        next.add(child);
                    }
                }
            }
            queue = next;
        }
        return null;
    }

    private List<Position> genPositionPath(Position start, Position end) {
        Position cur = end;
        LinkedList<Position> res = new LinkedList<>();
        while (cur != null) {
            res.addFirst(cur);
            cur = cur.pre;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
        };
        Solution s = new Solution();
        Position start = new Position(0,0);
        Position end = new Position(1,3);

        s.getShortest(board, start, end);
    }
}
