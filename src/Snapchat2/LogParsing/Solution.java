package Snapchat2.LogParsing;

import java.util.*;

public class Solution {
    static class Record {
        long ts;
        String name;
        Type type;

        public Record(long ts, String name, Type type) {
            this.ts = ts;
            this.name = name;
            this.type = type;
        }

        enum Type {
            START,
            END
        }
    }

    static class Task {
        Record record;
        Long cost;
        Long currentEnd;

        public Task(Record record, Long cost, Long currentEnd) {
            this.record = record;
            this.cost = cost;
            this.currentEnd = currentEnd;
        }
    }

    public Map<String, Long> parse(List<Record> log) {
        Map<String, Long> map = new HashMap<>(log.size());
        Stack<Task> stack = new Stack<>();
        for (Record record : log) {
            if (record.type == Record.Type.START) {
                if (!stack.isEmpty()) {
                    stack.peek().cost += record.ts - stack.peek().currentEnd;
                    stack.peek().currentEnd = record.ts;
                }
                stack.push(new Task(record, 0l, record.ts));
            } else {
                Task task = stack.pop();
                map.put(task.record.name, task.cost + record.ts - task.currentEnd);
                if (!stack.isEmpty()) {
                    stack.peek().currentEnd = record.ts;
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().parse(Arrays.asList(
                new Record(0, "f1", Record.Type.START),
                new Record(2, "f2", Record.Type.START),
                new Record(4, "f3", Record.Type.START),
                new Record(5, "f3", Record.Type.END),
                new Record(8, "f2", Record.Type.END),
                new Record(9, "f1", Record.Type.END)
        )));
    }
}
