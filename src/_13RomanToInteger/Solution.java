package _13RomanToInteger;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] cs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            int number = map.get(cs[i]);
            if (i != cs.length - 1 && number < map.get(cs[i+1])) {
                res -= number;
            } else {
                res += number;
            }
        }
        return res;
    }
}
