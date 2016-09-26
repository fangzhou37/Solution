package _12IntegerToRoman;

public class Solution {
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
