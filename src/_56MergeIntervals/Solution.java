package _56MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        List<Interval> res = new ArrayList<>();
        for (Interval cur : intervals) {
            if (res.isEmpty()) {
                res.add(cur);
            } else if (overlap(res.get(res.size()-1), cur)) {
                res.set(res.size()-1, merge(res.get(res.size()-1), cur));
            } else {
                res.add(cur);
            }
        }
        return res;
    }

    private boolean overlap(Interval cur, Interval newInterval) {
        if (newInterval == null) {
            return false;
        }
        return cur.start <= newInterval.end && newInterval.start <= cur.end;
    }

    private Interval merge(Interval cur, Interval newInterval) {
        if (newInterval == null) {
            return cur;
        }
        return new Interval(Math.min(cur.start, newInterval.start), Math.max(cur.end, newInterval.end));
    }
}
