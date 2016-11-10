package Snapchat2.MeetingRoomSchedule;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    static class Room {
        static AtomicInteger globalIdProvider = new AtomicInteger(0);
        int id;

        public Room() {
            id = globalIdProvider.getAndIncrement();
        }

        @Override
        public String toString() {
            return "Room{" + id +
                    '}';
        }
    }

    public Map<Interval, Room> scheduleMeetingRooms(final Interval[] intervals) {
        Map<Interval, Room> schedule = new HashMap<>(intervals.length);
        if (intervals.length == 0) {
            return schedule;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        LinkedList<Room> availableRooms = new LinkedList<>();
        PriorityQueue<Interval> ongoing = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        schedule.put(intervals[0], new Room());
        ongoing.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            while (!ongoing.isEmpty() && ongoing.peek().end <= cur.start) {
                Interval finishedMeeting = ongoing.poll();
                availableRooms.addLast(schedule.get(finishedMeeting));
            }
            if (availableRooms.isEmpty()) {
                availableRooms.addLast(new Room());
            }
            schedule.put(cur, availableRooms.pollFirst());
            ongoing.add(cur);
        }

        return schedule;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] {
          new Interval(2,6),
          new Interval(1,5),
          new Interval(3,8),
          new Interval(7,9),
          new Interval(0,9),
          new Interval(7,9)
        };
        System.out.println(new Solution().scheduleMeetingRooms(intervals));
    }
}
