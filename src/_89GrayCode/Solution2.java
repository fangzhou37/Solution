package _89GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>((int) Math.pow(2, n));
        if (n == 0) {
            return res;
        }
        res.add(0);
        res.add(1);
        for (int i = 1; i < n; i++) {
            int size = res.size();
            int mask = (1 << i);
            for (int j = size-1; j >= 0; j--) {
                res.add(res.get(j) | mask);
            }
        }
        return res;
    }
}
