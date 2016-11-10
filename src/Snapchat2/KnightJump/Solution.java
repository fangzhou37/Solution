package Snapchat2.KnightJump;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    static class Position {
        int x;
        int y;

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

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static final int[][] childDirections = new int[][] {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};

    public List<Position> findPath(int[][] board, Position start, Position end) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        LinkedList<Position> queue = new LinkedList<>();
        Map<Position, Position> parent = new HashMap<>();   // <child, parent>
        queue.addLast(start);
        while (!queue.isEmpty()) {
            Position cur = queue.removeFirst();
            if (cur.equals(end)) {
                return generatePath(parent, start, end, board);
            }
            if (visited[cur.x][cur.y]) {
                continue;
            }
            visited[cur.x][cur.y] = true;
            for (int[] childDirection : childDirections) {
                int x = cur.x + childDirection[0];
                int y = cur.y + childDirection[1];
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                    continue;
                }
                Position child = new Position(x, y);
                if (!parent.containsKey(child)) {
                    parent.put(child, cur);
                }
                queue.addLast(new Position(x, y));
            }
        }
        return new LinkedList<>();
    }

    private List<Position> generatePath(Map<Position, Position> parent, Position start, Position end, int[][] board) {
        LinkedList<Position> path = new LinkedList<>();
        Position cur = end;
        int i = 1;
        while (cur != start) {
            board[cur.x][cur.y] = i++;
            path.addFirst(cur);
            cur = parent.get(cur);
        }
        board[cur.x][cur.y] = i++;
        path.addFirst(start);
        return path;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
        };
        System.out.println(new Solution().findPath(board, new Position(0,0), new Position(7,7)));

        for (int[] row : board) {
            for (int col : row) {
                System.out.print(col + ",");
            }
            System.out.println();
        }
    }
}
