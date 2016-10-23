package Snapchat.LogParse;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // function, timestamp，act
    public Map<String, Interval> parse(String[] log) {
        Map<String, Interval> res = new HashMap<>();
        for (String line : log) {
            String[] fields = line.split(",");
            if (!res.containsKey(fields[0])) {
                res.put(fields[0], new Interval(0, 0));
            }
            if (fields[2] == "START") {
                res.get(fields[0]).start = Integer.valueOf(fields[1]);
            }
            if (fields[2] == "END") {
                res.get(fields[0]).end = Integer.valueOf(fields[1]);
            }
        }
        return res;
    }
}
