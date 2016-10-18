package _252MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.end;
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}
