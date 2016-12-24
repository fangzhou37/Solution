package SnapchatPhoneAndOnsite.LogAggregation;

import java.util.*;

public class Solution {
    static class Log {
        String data;
        long ts;

        public Log(String data, long ts) {
            this.data = data;
            this.ts = ts;
        }

        @Override
        public String toString() {
            return "{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

    enum Gran {
        MINUTE,
        HOUR,
        DAY
    }

    static class LogStorage {
        TreeMap<Long, List<Log>> minutesMap = new TreeMap<>();
        TreeMap<Long, List<Log>> hoursMap = new TreeMap<>();
        TreeMap<Long, List<Log>> daysMap = new TreeMap<>();

        public void add(Log log) {
            addToMap(roundToMinute(log.ts), log, minutesMap);
            addToMap(roundToHour(log.ts), log, hoursMap);
            addToMap(roundToDay(log.ts), log, daysMap);
        }

        private void addToMap(Long roundedTs, Log log, Map<Long, List<Log>> map) {
            if (!map.containsKey(roundedTs)) {
                map.put(roundedTs, new LinkedList<Log>());
            }
            map.get(roundedTs).add(log);
        }


        private Long roundToMinute(long ts) {
            return ts / 1000;
        }

        private Long roundToHour(long ts) {
            return ts / 1000 / 60;
        }

        private Long roundToDay(long ts) {
            return ts/ 1000/ 60 / 24;
        }

        public List<List<Log>> query(long start, long end, Gran gran) {
            TreeMap<Long, List<Log>> mapOfGran = getMap(gran);
            Long roundedStart = round(start, gran);
            Long roundedEnd = round(end, gran);
            SortedMap<Long, List<Log>> res = mapOfGran.subMap(roundedStart, roundedEnd);
            return new LinkedList<>(res.values());
        }

        private Long round(long ts, Gran gran) {
            if (gran.equals(Gran.MINUTE)) {
                return ts / 1000;
            }
            if (gran.equals(Gran.HOUR)) {
                return ts/ 1000 / 60;
            }
            if (gran.equals(Gran.DAY)) {
                return ts/ 1000 / 60 / 24;
            }
            return null;
        }

        private TreeMap<Long, List<Log>> getMap(Gran gran) {
            if (gran.equals(Gran.MINUTE)) {
                return minutesMap;
            }
            if (gran.equals(Gran.HOUR)) {
                return hoursMap;
            }
            if (gran.equals(Gran.DAY)) {
                return daysMap;
            }
            // throw exception, should not hit this
            return null;
        }
    }

    public static void main(String[] args) {
        LogStorage logStorage = new LogStorage();
        logStorage.add(new Log("1", 12345));
        logStorage.add(new Log("1", 12345));
        logStorage.add(new Log("3", 12346));
        logStorage.add(new Log("4", 13345));
        logStorage.add(new Log("4", 13345));
        logStorage.add(new Log("5", 14445));
        logStorage.add(new Log("6", 14445));
        logStorage.add(new Log("6", 14445));
        // [4,4] [5,6,6]
        System.out.println(logStorage.query(13000, 15000, Gran.MINUTE));
    }
}
