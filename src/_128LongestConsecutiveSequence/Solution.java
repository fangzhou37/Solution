package _128LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        // <number, reach>
        Map<Integer, Integer> m = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (m.containsKey(n)) {
                continue;
            }
            int start = m.containsKey(n-1) ? m.get(n-1) : n;
            int end = m.containsKey(n+1) ? m.get(n+1) : n;
            if (start == end) {
                m.put(n, n);
            }
            if (start != n) {
                m.put(start, n);
                m.put(n, start);
            }
            if (end != n) {
                m.put(end, n);
                m.put(n, end);
            }
            if (start != n && end != n) {
                m.put(start, end);
                m.put(end, start);
            }
            if (!m.containsKey(n)) {
                m.put(n, n);
            }
            int length = end - start + 1;
            max = max < length ? length : max;
        }
        return max;
    }
}
