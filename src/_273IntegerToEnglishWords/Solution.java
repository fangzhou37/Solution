package _273IntegerToEnglishWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] groupUnit = new String[] {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) { // 易错
            return "Zero";
        }
        List<Integer> groups = new ArrayList<>();
        while (num != 0) {
            groups.add(num % 1000);
            num /= 1000;
        }
        StringBuffer sb = new StringBuffer();

        for (int i = groups.size()-1; i >= 0; i--) {
            String frontSpace = sb.length() != 0 ? " " : "";    // 易错
            String postSpace = i != 0 ? " " : "";               // 易错
            String below1000 = generateBelow1000(groups.get(i));
            below1000 = below1000.isEmpty() ? "" : frontSpace + below1000 + postSpace + groupUnit[i];
            sb.append(below1000);
        }
        return sb.toString();
    }

    private String generateBelow1000(Integer n) {
        if (n < 10) {
            return belowTen[n];
        }
        if (n < 20) {
            return belowTwenty[n-10];
        }
        Integer hundredDigit = n / 100;
        if (hundredDigit != 0) {
            String tenthDigit = generateBelow1000(n%100);
            tenthDigit = tenthDigit.isEmpty() ? "" : " " + tenthDigit;    // 易错
            return belowTen[hundredDigit] + " Hundred" + tenthDigit;
        }
        Integer tenthDigit = n / 10;
        if (tenthDigit != 0) {
            String singleDigit = generateBelow1000(n%10);
            singleDigit = singleDigit.isEmpty() ? "" : " " + singleDigit;
            return belowHundred[tenthDigit] + singleDigit;
        }
        return "";  // in case n == 0    // 易错
    }
}
