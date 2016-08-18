package _384ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] ori = null;

    public Solution(int[] nums) {
        ori = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ori;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (ori.length == 0) {
            return ori;
        }
        int[] copy = Arrays.copyOf(ori, ori.length);
        for (int i = 0; i < ori.length; i++) {
            int j = new Random().nextInt(ori.length);
            int t = copy[i];
            copy[i] = copy[j];
            copy[j] = t;
        }
        return copy;
    }
}
