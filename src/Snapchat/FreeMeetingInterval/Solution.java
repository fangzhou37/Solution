package Snapchat.FreeMeetingInterval;

import java.util.*;

public class Solution {
    public List<Interval> findFreeTimes(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        Interval cur = null;
        List<Interval> freeTimeList = new LinkedList<>();
        for (Interval i : intervals) {
            if (cur == null) {
                cur = i;
            } else if (haveOverlap(cur, i)) {
                cur.start = Math.min(cur.start, i.start);
                cur.end = Math.max(cur.end, i.end);
            } else {
                freeTimeList.add(new Interval(cur.end, i.start));
                cur = i;
            }
        }
        return freeTimeList;
    }

    private boolean haveOverlap(Interval i, Interval j) {
        return !(i.start >= j.end || j.start >= i.end);
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(1,5));
        intervals.add(new Interval(4,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(9,10));
        intervals.add(new Interval(15,16));
        intervals.add(new Interval(17,20));
        Collections.shuffle(intervals);
        System.out.println(new Solution().findFreeTimes(intervals));
    }
}
