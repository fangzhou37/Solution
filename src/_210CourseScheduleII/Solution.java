package _210CourseScheduleII;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final int[] order = new int[numCourses];
        int[][] m = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int pre = pair[0], cur = pair[1];
            if (m[pre][cur] != 1) {
                indegree[cur]++;
            }
            m[pre][cur] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                order[i] = 0;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < numCourses; i++) {
                if (m[cur][i] != 0) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                        order[i] = Math.max(order[i], order[cur]+1);
                    }
                }
            }
        }
        for (int indeg : indegree) {
            if (indeg != 0) {
                return new int[0];
            }
        }
        Integer[] path = new Integer[numCourses];
        for (int i = 0; i < numCourses; i++) {
            path[i] = i;
        }
        Arrays.sort(path, 0, numCourses, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return order[o2] - order[o1];
            }
        });
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = path[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findOrder(5, new int[][] {{1,0},{1,2},{2,3},{0,3}}));
    }
}
