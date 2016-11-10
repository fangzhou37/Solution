package Snapchat2.MeetingWeightMaximum;

import java.util.*;

public class Solution {
    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "{" +start +
                    "," + end + '}';
        }
    }

    public int getMaxWeight(Interval[] intervals, int[] weight) {
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> m = new TreeMap<>();  // <end, max weight that ends here>
        Map<Interval, Integer> index = new HashMap<>(intervals.length);    // <Interval, index>
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(max, weight[i]);
            m.put(intervals[i].end, weight[i]);
            index.put(intervals[i], i);
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        Integer preMax = Integer.MIN_VALUE;
        for (Interval i : intervals) {
            Integer firstSmaller = m.floorKey(i.start);
            if (firstSmaller == null) {
                continue;
            }
            int curMax = m.get(firstSmaller) + weight[index.get(i)];
            curMax = Math.max(preMax, curMax);
            if (m.get(i.end) < curMax) {
                m.put(i.end, curMax);
                max = Math.max(max, curMax);
            }
            preMax = curMax;
        }
        return max;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] {
                new Interval(1,3),
                new Interval(2,6),
                new Interval(0,8),
                new Interval(4,6),
        };
        System.out.println(new Solution().getMaxWeight(intervals, new int[] {3,5,6,4}));
    }
}
