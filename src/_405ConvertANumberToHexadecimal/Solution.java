package _405ConvertANumberToHexadecimal;

public class Solution {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if (num == 0) { // 易错
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.append(map[(num & 15)]); // 易错, &15 和%16 不同, &15会忽略符号, %16会考虑符号
            num >>>= 4; // 易错,这里应该用无符号位移
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().toHex(-1));
    }
}
