package _60PermutationSequence;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*
    * 反过来想, 给一个数: a1, a2, a3, ... an,  如何知道是第几个? (求k)
    * k = <a1前可能的数> * (n-1)! + <除去a1, a2前可能的数> * (n-2)! + ...
    *
    * e.g. 给"231" 求k:
    * 第一位是2, 2前只有1 (1种可能), 所以前面的数一定是1**。 有2!种可能
    * 第二位, 3前只有1 (2已经被挑走,不算。) 所以前面的数一定是 21*。 有1!种可能。
    * 第三位, 1前已经没有数字, 所以是第一个。
    * 所以前面有 1 * 2! + 1 * 1! + 0 * 0! = 3个数
    * 这是第k+1 = 4个数,前面三个分别为123, 132, 213
    * */
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i*fact[i-1];
        }

        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);

        StringBuilder sb = new StringBuilder();
        int x;
        k = k-1;
        for (int i = n; i > 0; i--){
            x = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.remove(x));
        }
        return sb.toString();
    }
}
