package _386LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            list.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                // 如果不加cur % 10 != 9 就会出现19 -> 20   而不是得到正确的2
                cur++;
            } else {
                // 1199 -> 12
                // 为了预防cur / 10 + 1出现进位,要先剥离尾部多于一个的9
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(13));
    }
}
