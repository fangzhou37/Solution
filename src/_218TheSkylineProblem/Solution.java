package _218TheSkylineProblem;

import java.util.*;

class Point {
    int[] data;

    public Point(int[] data) {
        this.data = data;
    }
}

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // 所有关键点
        Set<Integer> pivotsSet = new HashSet<>();
        for (int[] building : buildings) {
            pivotsSet.add(building[0]);
            pivotsSet.add(building[1]);
        }
        Integer[] pivots = pivotsSet.toArray(new Integer[0]);
        Arrays.sort(pivots);

        List<int[]> res = new LinkedList<>();
        if (buildings.length == 0) {
            return res;
        }
        PriorityQueue<Point> queue = new PriorityQueue<>(buildings.length, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.data[2] - o1.data[2];
            }
        });
        int buildingIndex = 0;
        int previousHight = 0;
        for (Integer point : pivots) {
            if (buildingIndex < buildings.length && point == buildings[buildingIndex][0]) {
                // 进：push qualified buildings (which start at this point) into the queue
                while (buildingIndex < buildings.length && point == buildings[buildingIndex][0]) {
                    queue.add(new Point(buildings[buildingIndex]));
                    buildingIndex++;
                }
            }

            if (!queue.isEmpty() && point >= queue.peek().data[1]) {
                // 出：poll some buildings out
                while (!queue.isEmpty() && point >= queue.peek().data[1]) {
                    queue.poll();
                }
            }

            // 刷新新高度
            if (queue.isEmpty()) {  // drop to y = 0
                if (previousHight != 0) {
                    res.add(new int[]{point, 0});
                }
            } else {
                if (previousHight != queue.peek().data[2]) {
                    res.add(new int[]{point, queue.peek().data[2]});
                    previousHight = queue.peek().data[2];
                }
            }
        }
        return res;
    }
}
