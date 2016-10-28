package Snapchat.MaxTimeStamps;

public class Solution {
    public double getRange(double[] timestamps, double window) {
        if (timestamps.length == 0 || window < 0.0d) {
            return -1;
        }
        int start = 0;
        int maxTimeStampInWindow = 0;
        double resultStartTimeStamp = -1;
        for (int i = 0; i < timestamps.length; i++) {
            while (start <= i && timestamps[i] > timestamps[start] + window) {
                start++;
            }
            if (maxTimeStampInWindow < i - start + 1) {
                resultStartTimeStamp = timestamps[start];
                maxTimeStampInWindow = i - start + 1;
            }
        }
        return resultStartTimeStamp;
    }

    public static void main(String[] args) {
        double[] timestamps = new double[] {1.2, 2, 2.3, 5.0, 5.3, 5.6, 5,7, 5.8};
        System.out.println(new Solution().getRange(timestamps, 3));
        System.out.println(new Solution().getRange(timestamps, 5));
        System.out.println(new Solution().getRange(timestamps, 0.2));
        System.out.println(new Solution().getRange(timestamps, 0.1));
    }
}
