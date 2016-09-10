package _179LargestNumber;

import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        List<String> l = new ArrayList<>();
        for (int n : nums) {
            l.add(String.valueOf(n));
        }
        Collections.sort(l, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if (!l.isEmpty() && l.get(0).charAt(0) == '0') {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (String s : l) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[] {30,1,52,8,11,2}));
    }
}
