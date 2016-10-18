package _253MeetingRoomsII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public int minMeetingRooms(final Interval[] intervals) {
        if(intervals==null||intervals.length==0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0].end);
        int max = 1;
        for (int i = 1; i < intervals.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= intervals[i].start) {
                queue.poll();
            }
            queue.offer(intervals[i].end);
            max = Math.max(max, queue.size());
        }
        return max;
    }

    public static void main(String[] args) {
        Interval[] arr = new Interval[] {
                new Interval(0,3),
                new Interval(1,4),
                new Interval(2,6),
                new Interval(2,6),
                new Interval(5,7),
                new Interval(8,9),
                new Interval(11,15),
                new Interval(11,15),
                new Interval(12,15),
                new Interval(13,16),
                new Interval(4,16),
                new Interval(2,6),
                new Interval(7,16),
                new Interval(3,6),
                new Interval(2,6),
                new Interval(2,8),
                new Interval(0,3),
                new Interval(1,4),
                new Interval(2,6),
                new Interval(2,6),
                new Interval(5,7),
                new Interval(8,9),
                new Interval(11,15),
                new Interval(11,15),
                new Interval(12,15),
                new Interval(13,16),
                new Interval(4,16),
                new Interval(2,6),
                new Interval(7,16),
                new Interval(3,6),
                new Interval(2,6),
                new Interval(2,8),
        };
        System.out.println(new Solution2().minMeetingRooms(arr));
        System.out.println(new Solution().minMeetingRooms(arr));
    }
}