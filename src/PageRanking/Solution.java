package PageRanking;

import java.util.*;

public class Solution {

    // http://www.1point3acres.com/bbs/thread-200824-1-1.html
    static class Item {
        public Item(int hostId, int listId, double score) {
            this.hostId = hostId;
            this.listId = listId;
            this.score = score;
        }

        int hostId;
        int listId;
        double score;

        @Override
        public String toString() {
            return "" + hostId + "," + listId;
        }
    }

    public List<List<Item>> getPages(int pageSize, List<Item> items) {
        List<List<Item>> res = new LinkedList<>();
        Map<Integer, LinkedList<Item>> map = groupRecordsByHostId(items);
        PriorityQueue<LinkedList<Item>>  queue = new PriorityQueue<>(map.size(), new Comparator<LinkedList<Item>>() {
            @Override
            public int compare(LinkedList<Item> o1, LinkedList<Item> o2) {
                double score1 = o1.getFirst().score, score2 = o2.getFirst().score;
                if (Math.abs(score1 - score2) < 0.0000001) {
                    return 0;
                }
                return score1 < score2 ? 1 : -1;    // reverse comparator since we want to keep the order (larger first)
            }
        });

        List<LinkedList<Item>> buffer = new LinkedList<>();
        List<Item> page = new LinkedList<>();
        queue.addAll(map.values());
        while (!queue.isEmpty()) {
            for (int i = 0; i < pageSize; i++) {
                if (queue.isEmpty() && buffer.isEmpty()) {
                    break;
                }
                if (queue.isEmpty()) {
                    queue.addAll(buffer);
                    buffer.clear();
                }
                LinkedList<Item> cur = queue.poll();
                page.add(cur.removeFirst());
                if (!cur.isEmpty()) {
                    buffer.add(cur);
                }
            }
            res.add(new LinkedList<>(page));
            page.clear();
            queue.addAll(buffer);
            buffer.clear();
        }
        return res;
    }

    private Map<Integer, LinkedList<Item>> groupRecordsByHostId(List<Item> items) {
        Map<Integer, LinkedList<Item>> map = new HashMap<>(); // host id -> <item>
        for (Item item : items) {
            if (!map.containsKey(item.hostId)) {
                map.put(item.hostId, new LinkedList<Item>());
            }
            map.get(item.hostId).addLast(item); // keep sorted (larger first)
        }
        return map;
    }

    public static void main(String[] args) {
        Item[] records = new Item[] {
                new Item(10, 1, 1000.0),
                new Item(10, 3, 999.5),
                new Item(9, 2, 999.0),
                new Item(15, 999, 858),
                new Item(10, 5,747.0),
        };
        Solution s = new Solution();
        System.out.println(s.getPages(3, Arrays.asList(records)));
    }
}
