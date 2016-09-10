package _207CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
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
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < numCourses; i++) {
                if (m[cur][i] != 0) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        for (int indeg : indegree) {
            if (indeg != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];  // Map<Integer, List<Integer>>
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(3, new int[][] {{1,0}, {2,0}}));
    }
}
