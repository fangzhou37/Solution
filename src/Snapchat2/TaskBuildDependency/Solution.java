package Snapchat2.TaskBuildDependency;

import java.util.*;

public class Solution {
    static class Task {
        List<Task> depends;
        int id;

        public Task(int id) {
            this.id = id;
            depends = new LinkedList<>();
        }

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    '}';
        }
    }

    public List<Task> findOrder(Task[] list) {
        if (list.length == 0) {
            return new LinkedList<>();
        }

        int[] indegree = new int[list.length];
        final int[] outdegree = new int[list.length];
        final Map<Task, Integer> map = new HashMap<>(list.length);    // <task, index>
        for (int i = 0; i < list.length; i++) {
            map.put(list[i], i);
        }
        for (Task task : list) {
            outdegree[map.get(task)] += task.depends.size();
            for (Task child : task.depends) {
                indegree[map.get(child)]++;
            }
        }

        PriorityQueue<Task> queue = new PriorityQueue<>(list.length, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return outdegree[map.get(o1)] - outdegree[map.get(o2)];
            }
        });
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(list[i]);
            }
        }

        List<Task> res = new LinkedList<>();
        Set<Task> visited = new HashSet<>(list.length);
        while (!queue.isEmpty()) {
            Task t = queue.poll();
            res.add(t);
            visited.add(t);
            for (Task child : t.depends) {
                indegree[map.get(child)]--;
                if (indegree[map.get(child)] == 0 && !visited.contains(child)) {
                    queue.add(child);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Task[] list = new Task[] {
          new Task(0),
          new Task(1),
          new Task(2),
          new Task(3),
          new Task(4),
          new Task(5),
          new Task(6),
          new Task(7),
          new Task(8)
        };

        list[0].depends.add(list[1]);
        list[0].depends.add(list[2]);
        list[2].depends.add(list[3]);
        list[2].depends.add(list[4]);
        list[4].depends.add(list[3]);

        list[5].depends.add(list[6]);
        list[6].depends.add(list[3]);

        list[7].depends.add(list[8]);

        System.out.println(new Solution().findOrder(list));
    }
}
