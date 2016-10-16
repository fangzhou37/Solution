package PerfectRound;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    // http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=146539&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D37%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    class DiffFromCeil {
        public DiffFromCeil(int index, float diff) {
            this.index = index;
            this.diff = diff;
        }

        int index;
        float diff;
    }

    public int[] round(float[] prices) {
        int[] res = new int[prices.length];
        float sum = 0;
        int intSum = 0;
        DiffFromCeil[] diffFromCeil = new DiffFromCeil[prices.length];
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
            intSum += (int) prices[i];  // their floors
            res[i] = (int) prices[i];
            diffFromCeil[i] = new DiffFromCeil(i, (float) (Math.ceil(prices[i]) - prices[i])); // difference from ceiling
        }
        int missNumber = (int) Math.ceil(sum - intSum); // e.g. if missNumber == 2, need to bump 2 numbers to ceil int
        PriorityQueue<DiffFromCeil> queue = new PriorityQueue<>(prices.length, new Comparator<DiffFromCeil>() {
            @Override
            public int compare(DiffFromCeil o1, DiffFromCeil o2) {
                if (Math.abs(o1.diff - o2.diff) < 0.000001) {
                    return 0;
                }
                return o1.diff > o2.diff ? 1 : -1;
            }
        });
        queue.addAll(Arrays.asList(diffFromCeil));
        for (int i = 0; i < missNumber; i++) {
            DiffFromCeil node = queue.poll();
            res[node.index] = (int) Math.ceil(prices[node.index]);
        }

        return res;
    }

    public static void main(String[] args) {
        float[] prices = new float[] {1.2f, 2.3f, 3.4f};
        int[] rounds = new Solution().round(prices);
        for (int i : rounds) {
            System.out.println(i);
        }
    }
}
