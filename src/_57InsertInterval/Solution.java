package _57InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval cur : intervals) {
            if (overlap(cur, newInterval)) {
                newInterval = merge(cur, newInterval);
            } else if (isSmaller(cur, newInterval)) {
                res.add(cur);
            } else {
                res.add(newInterval);
                res.add(cur);
                newInterval = null;
            }
        }
        if (newInterval != null) {
            res.add(newInterval);
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

    private boolean isSmaller(Interval cur, Interval newInterval) {
        if (newInterval == null) {
            return true;
        }
        return cur.end < newInterval.start;
    }
}
