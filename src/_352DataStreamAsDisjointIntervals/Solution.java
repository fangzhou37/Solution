package _352DataStreamAsDisjointIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class SummaryRanges {
    TreeMap<Integer, Interval> m;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        m = new TreeMap<>();
    }

    public void addNum(int val) {
        if (m.containsKey(val)) {
            return;
        }
        Integer ceil = m.ceilingKey(val);
        Integer floor = m.floorKey(val);
        if (ceil != null && floor != null && ceil == val + 1 && m.get(floor).end == val - 1) {
            m.get(floor).end = m.get(ceil).end; // merge floor with ceil and remove ceil
            m.remove(ceil);
        } else if (ceil != null && ceil == val + 1) {
            m.put(val, new Interval(val, m.get(ceil).end));  // create new interval start with cur, remove with ceil
            m.remove(ceil);
        } else if (floor != null && m.get(floor).end >= val - 1) {  // 易错,如果用m.get(floor).end >= val - 1, 在floor.end 范围内的val会进入下一个else,产生多余的entry
            Interval floorInterval = m.get(floor);  // update floor interval
            floorInterval.end = Math.max(val, floorInterval.end);
        } else {
            m.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(m.values());
    }
}

public class Solution {
}
