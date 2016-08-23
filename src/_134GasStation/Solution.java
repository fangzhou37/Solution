package _134GasStation;

public class Solution {
    // Whenever the sum is negative, reset it and let the car start from next point.
    // In the mean time, add up all of the left gas to total. If it's negative finally,
    // return -1 since it's impossible to finish.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;  // extra fuel left at the end of a full circle. Could be negative if gas is not enough for a full circle
        int cur = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += (gas[i] - cost[i]);
            total += (gas[i] - cost[i]);    // could be positive or negative
            if (cur < 0) {
                start = i+1;
                cur = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
