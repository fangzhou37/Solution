package _60PermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        List<Integer> remains = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            remains.add(i);
        }
        while (k > 0 && !remains.isEmpty()) {
            int thisDigit = (k + 1) / (n - 1);
            sb.append(remains.get(thisDigit - 1));
            remains.remove(thisDigit - 1);
            k = (k + 1) % (n - 1);
            k++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.println(new Solution2().getPermutation(3, i));
        }
    }
}
